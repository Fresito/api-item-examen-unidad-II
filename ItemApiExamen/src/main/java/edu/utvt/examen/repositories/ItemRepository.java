package edu.utvt.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.utvt.examen.entities.Item;

public interface ItemRepository extends JpaRepository<Item, String> {

}
