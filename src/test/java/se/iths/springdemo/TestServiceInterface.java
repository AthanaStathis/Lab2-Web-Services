package se.iths.springdemo;


import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogAge;
import se.iths.springdemo.services.ServiceInterface;

import java.util.List;
import java.util.Optional;

public class TestServiceInterface implements ServiceInterface {
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
    public DogDto updateDog(int i, DogAge dogDto) {
        return null;
    }

    @Override
    public List<DogDto> getDogByGender(String gender) {
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

