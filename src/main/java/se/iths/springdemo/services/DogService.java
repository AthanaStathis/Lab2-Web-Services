package se.iths.springdemo.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springdemo.mappers.DogMapper;
import se.iths.springdemo.repositories.DogRepository;
import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.Dog;
import se.iths.springdemo.entities.DogEmail;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class DogService implements Service{
    private final DogMapper dogMapper = new DogMapper();
    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public List<DogDto> getAllDogs() {
        return dogMapper.mapp(dogRepository.findAll());
    }

    @Override
    public Optional<DogDto> getOne(Long id) {
        //return personRepository.findById(id);
        return dogMapper.mapp(dogRepository.findById(id));
    }

    @Override
    public DogDto createDog(DogDto dog) {
        if (dog.getName().isEmpty())
            throw new RuntimeException();
        //return personRepository.save(person);
        return dogMapper.mapp(dogRepository.save(dogMapper.mapp(dog)));
    }

    @Override
    public void delete(Long id) {
        dogRepository.deleteById(id);
    }

    @Override
    public DogDto replace(Long id, DogDto dogDto) {
        Optional<Dog> dog =  dogRepository.findById(id);
        if (dog.isPresent()) {
            Dog updatedDog = dog.get();
            updatedDog.setName(dogDto.getName());
            updatedDog.setEmail(dogDto.getEmail());
            return dogMapper.mapp(dogRepository.save(updatedDog));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found.");
        }
    }

    @Override
    public DogDto update(Long id, DogEmail dogDto) {
        Optional<Dog> dog =  dogRepository.findById(id);
        if (dog.isPresent()) {
            Dog updatedDog = dog.get();
            if (dogDto.email != null)
                updatedDog.setEmail(dogDto.email);
            updatedDog.setEmail(dogDto.email);
            return dogMapper.mapp(dogRepository.save(updatedDog));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Id " + id + " not found.");
        }
    }
}


