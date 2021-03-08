package se.iths.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.springdemo.entities.Dog;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

    List<Dog> findAllByName(String name);

    List<Dog> findAllByGender(String gender);

    List<Dog> findAllByType(String type);

}


