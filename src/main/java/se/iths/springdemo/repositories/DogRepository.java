package se.iths.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.springdemo.entities.Dog;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
    // Hanterar koppling mot en databas
    // List<Dog> findAllByName(String name);

}


