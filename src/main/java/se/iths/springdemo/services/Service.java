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

    Optional<DogDto> getOneDog(int id);

    DogDto createDog(DogDto dog);

    boolean deleteDog(int id);

    DogDto replaceDog(int id, DogDto dogDto);

    DogDto updateDog(int id, DogName dogDto);

    DogDto updateDog(int id, DogType dogDto);

    DogDto updateDog(int i, DogWeight dogDto);

    DogDto updateDog(int i, DogGender dogDto);

    List<DogDto> getDogGender(String gender);

    List<DogDto> getDogByName(String name);

    List<DogDto> getDogByType(String type);

}
