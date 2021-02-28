package se.iths.springdemo;

import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogEmail;
import se.iths.springdemo.services.Service;

import java.util.List;
import java.util.Optional;

public class TestService implements Service {
    @Override
    public List<DogDto> getAllDogs() {
        return null;
    }

    @Override
    public Optional<DogDto> getOne(Long id) {
        if(id == 1)
            return Optional.of(new DogDto(1,"Test","Test"));
        return Optional.empty();
    }

    @Override
    public DogDto createDog(DogDto dog) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public DogDto replace(Long id, DogDto dogDto) {
        return null;
    }

    @Override
    public DogDto update(Long id, DogEmail dogDto) {
        return null;
    }
}
