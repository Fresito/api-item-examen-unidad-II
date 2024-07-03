package edu.utvt.examen.services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import edu.utvt.examen.entities.Item;


public interface ItemService {
	

	public Item save(Item item);
	
	public Item update(String id, Item item);
	
	public Optional<Item> findById(String id);
	
	public ResponseEntity<Item> deleteById(String id);

}
