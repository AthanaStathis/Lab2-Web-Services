package se.iths.springdemo;


import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogGender;
import se.iths.springdemo.entities.DogName;
import se.iths.springdemo.entities.DogType;
import se.iths.springdemo.entities.DogWeight;
import se.iths.springdemo.services.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public List<DogDto> getAllDogs() {
        return null;
    }

    @Override
    public Optional<DogDto> getOneDog(int id) {
        return Optional.empty();
    }

    @Override
    public DogDto createDog(DogDto dog) {
        return null;
    }

    @Override
    public boolean deleteDog(int id) {
        return false;
    }

    @Override
    public DogDto replaceDog(int id, DogDto dogDto) {
        return null;
    }

    @Override
    public DogDto updateDog(int id, DogName dogDto) {
        return null;
    }

    @Override
    public DogDto updateDog(int id, DogType dogDto) {
        return null;
    }

    @Override
    public DogDto updateDog(int i, DogWeight dogDto) {
        return null;
    }

    @Override
    public DogDto updateDog(int i, DogGender dogDto) {
        return null;
    }

    @Override
    public List<DogDto> getDogGender(String gender) {
        return null;
    }

    @Override
    public List<DogDto> getDogByName(String name) {
        return null;
    }

    @Override
    public List<DogDto> getDogByType(String type) {
        return null;
    }

/*
    @Override
    public List<DogDto> getAllDogs() {
        return null;
    }

    @Override
    public Optional<DogDto> getOne(int id) {
        if(id == 1)
            return Optional.of(new DogDto(1,"Test1","Test1", 11, "Test1"));
        return Optional.empty();
    }

    @Override
    public DogDto createDog(DogDto dog) {
        DogDto newDog = new DogDto(2,"Test2","Test2", 22, "Test2");
        return newDog;
    }
*/


}

