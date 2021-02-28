package se.iths.springdemo.services;

import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogEmail;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<DogDto> getAllDogs();

    Optional<DogDto> getOne(Long id);

    DogDto createDog(DogDto dog);

    void delete(Long id);

    DogDto replace(Long id, DogDto dogDto);

    DogDto update(Long id, DogEmail dogDto);
}
