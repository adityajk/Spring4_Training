package com.way2learnonline.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.way2learnonline.dto.ClusterDTO;
import com.way2learnonline.dto.DeploymentDTO;
import com.way2learnonline.dto.ServerDTO;
import com.way2learnonline.exceptions.ServerNotFoundException;
import com.way2learnonline.model.Cluster;
import com.way2learnonline.model.Deployment;
import com.way2learnonline.model.Server;
import com.way2learnonline.repository.ClusterRepository;
import com.way2learnonline.repository.DeploymentRepository;
import com.way2learnonline.repository.ServerRepository;



@Controller
@RequestMapping("/servers")
public class ServerController {
	
	@Autowired
	private ServerRepository serverRepository;
	
	@Autowired private DeploymentRepository deploymentRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<ServerDTO> getAllServers(){
		Iterable<Server>  servers=serverRepository.findAll();		
		return ServerResourceCreator.toResources(servers);
		
		
	}
	@RequestMapping(value="/{serverId}",method=RequestMethod.GET)
	public @ResponseBody ServerDTO getServerById(@PathVariable("serverId") Long serverId){
		Server server=serverRepository.findOne(serverId);
		if(server==null){
			throw new ServerNotFoundException("Server with Id "+serverId+" is Not found!!");
		}
		return ServerResourceCreator.toResource(server);
		
	}
	

	
	@RequestMapping(value="/{serverId}/deployments",method=RequestMethod.GET)
	public @ResponseBody List<DeploymentDTO> getAllDeploymentsOnServerById(@PathVariable("serverId") Long serverId){
		Iterable<Deployment>deployments= deploymentRepository.findDeploymentsByServerId(serverId);		
		return DeploymentResourceCreator.toResources(deployments);
	}
	

	

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> addNewServer( @RequestBody ServerDTO serverDTO){
		
		Server server=serverDTO.createServer();
		
		server=serverRepository.save(server);
		
		
	
		
		URI newServerURI=ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(server.getServerId())
									.toUri();
		
		HttpHeaders responseHeaders= new HttpHeaders();
		responseHeaders.setLocation(newServerURI);
		
		return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);
	}
	
	
	

}
