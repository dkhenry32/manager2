package com.myapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.myapp.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
	List<Item> findByName(String name);

}