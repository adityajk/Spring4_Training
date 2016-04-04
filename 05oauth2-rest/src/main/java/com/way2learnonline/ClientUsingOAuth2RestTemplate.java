package com.way2learnonline;

import java.util.Arrays;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import com.way2learnonline.dto.ClusterDTO;

public class ClientUsingOAuth2RestTemplate {

	public static void main(String[] args) {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setUsername("siva");
        resourceDetails.setPassword("secret");
        resourceDetails.setAccessTokenUri("http://localhost:8081/spring-security-oauth-server/oauth/token");
        resourceDetails.setClientId("clientId");
       // resourceDetails.setClientSecret("secret");
        resourceDetails.setGrantType("implicit");
        resourceDetails.setId("clusters");
        
        resourceDetails.setScope(Arrays.asList("read"));

        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
        restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));

        
       ClusterDTO clusterDTO=restTemplate.getForObject("http://localhost:8080/05oauth2-rest/clusters", ClusterDTO.class);
       System.out.println(clusterDTO.getClusterName());

	}

}
