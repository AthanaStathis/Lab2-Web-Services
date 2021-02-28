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

    @Override
    public void delete(int id) {

    }

    @Override
    public DogDto replace(int id, DogDto dogDto) {
        return null;
    }
    if
    @Override
    public DogDto update(int id, DogName dogDto) {
        return null;
    }

    @Override
    public DogDto update(int id, DogType dogDto) {
        return null;
    }

    @Override
    public DogDto update(int id, DogWeight dogDto) {
        return null;
    }

    @Override
    public DogDto update(int id, DogGender dogDto) {
        return null;
    }


}
