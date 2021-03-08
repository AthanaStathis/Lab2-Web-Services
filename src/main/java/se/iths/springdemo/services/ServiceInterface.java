package se.iths.springdemo.services;

import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogAge;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
    List<DogDto> getAllDogs();

    Optional<DogDto> getOneDog(int id);

    DogDto createDog(DogDto dog);

    boolean deleteDog(int id);

    DogDto replaceDog(int id, DogDto dogDto);

    DogDto updateDog(int i, DogAge dogDto);

    List<DogDto> getDogByGender(String gender);

    List<DogDto> getDogByType(String type);

}
