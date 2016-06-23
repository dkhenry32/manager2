package com.myapp.repository;

import com.myapp.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
	List<Item> findByName(String name);

}