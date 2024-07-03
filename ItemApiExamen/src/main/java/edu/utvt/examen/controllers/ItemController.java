package edu.utvt.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.examen.entities.Item;
import edu.utvt.examen.services.ItemService;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping
	public ResponseEntity<Item> save(@RequestBody Item item) {
		return ResponseEntity.created(null).body(this.itemService.save(item));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> update(@PathVariable String id, @RequestBody Item item) {
		return ResponseEntity.ok(this.itemService.update(id, item)) ;
	}

}
