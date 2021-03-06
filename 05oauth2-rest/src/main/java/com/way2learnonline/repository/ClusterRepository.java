package com.way2learnonline.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.way2learnonline.model.Cluster;

public interface ClusterRepository extends CrudRepository<Cluster, Long> {

}
