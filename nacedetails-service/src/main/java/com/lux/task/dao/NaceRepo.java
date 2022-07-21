 package com.lux.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lux.task.models.NaceItem;

public interface NaceRepo extends JpaRepository<NaceItem, Integer>{

}
