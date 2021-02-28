package se.iths.springdemo.services;

import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogGender;
import se.iths.springdemo.entities.DogName;
import se.iths.springdemo.entities.DogType;
import se.iths.springdemo.entities.DogWeight;

import java.util.List;
import java.util.Optional;

public interface Service {
    List<DogDto> getAllDogs();

    Optional<DogDto> getOne(int id);

    DogDto createDog(DogDto dog);

    void delete(int id);

    DogDto replace(int id, DogDto dogDto);

    DogDto update(int id, DogName dogDto);

    DogDto update(int id, DogType dogDto);

    DogDto update(int i, DogWeight dogDto);

    DogDto update(int i, DogGender dogDto);
}
