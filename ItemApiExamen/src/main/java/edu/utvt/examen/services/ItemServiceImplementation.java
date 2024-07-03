package edu.utvt.examen.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.examen.entities.Item;
import edu.utvt.examen.repositories.ItemRepository;

@Service
public class ItemServiceImplementation implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return this.itemRepository.save(item);
	}

	@Override
	public Item update(String id, Item item) {
		// TODO Auto-generated method stub
		
		Optional<Item> itemOptional = null;
		itemOptional = this.itemRepository.findById(id);
		
		if (itemOptional.isPresent()) {
			
			itemOptional.get().setId(item.getId());
			itemOptional.get().setNombre(item.getNombre());
			itemOptional.get().setEdad(item.getEdad());
			itemOptional.get().setFecha_nacimiento(item.getFecha_nacimiento());
			
			this.itemRepository.save(itemOptional.get());
			
		}
		
		return itemOptional.orElseThrow();
		
	}

	@Override
	public Optional<Item> findById(String id) {
		// TODO Auto-generated method stub
		return this.itemRepository.findById(id);
	}

	@Override
	public ResponseEntity<Item> deleteById(String id) {
		// TODO Auto-generated method stub
		
		Optional<Item> itemOptional = null;
		ResponseEntity<Item> responseEntity = null;
		
		itemOptional = this.itemRepository.findById(id);
		
		if (itemOptional.isPresent()) {
			
			this.itemRepository.delete(itemOptional.get());
			responseEntity = ResponseEntity.noContent().build();
			
		}
		else {
			responseEntity = ResponseEntity.notFound().build();
		}
		
		return responseEntity;
		
	}

}
