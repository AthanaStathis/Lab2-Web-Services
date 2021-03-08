package se.iths.springdemo.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springdemo.entities.*;
import se.iths.springdemo.mappers.DogMapper;
import se.iths.springdemo.repositories.DogRepository;
import se.iths.springdemo.dtos.DogDto;

import java.util.List;
import java.util.Optional;

@Service
public class DogService implements ServiceInterface {

    private DogMapper dogMapper = new DogMapper();
    private DogRepository dogRepository;

    public DogService(DogRepository dogRepository, DogMapper dogMapper) {
        this.dogRepository = dogRepository;
        this.dogMapper = dogMapper;
    }


    @Override
    public List<DogDto> getAllDogs() {
        return dogMapper.mapp(dogRepository.findAll());
    }


    @Override
    public Optional<DogDto> getOneDog(int id) {
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
    public boolean deleteDog(int id) {
        if(dogRepository.findById(id).isPresent()) {
            dogRepository.deleteById(id);
            return true;
        } else
            return false;
    }


    @Override
    public DogDto replaceDog(int id, DogDto dogDto) {
        Optional<Dog> dog =  dogRepository.findById(id);
        if (dog.isPresent()) {
            Dog updatedDog = dog.get();
            updatedDog.setName(dogDto.getName());
            updatedDog.setType(dogDto.getType());
            return dogMapper.mapp(dogRepository.save(updatedDog));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Dog with id: " + id + " not found.");
        }
    }


    @Override
    public DogDto updateDog(int id, DogAge dogDto) {
        Optional<Dog> dog =  dogRepository.findById(id);
        if (dog.isPresent()) {
            Dog updatedDog = dog.get();
            updatedDog.setAge(dogDto.age);
            return dogMapper.mapp(dogRepository.save(updatedDog));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Dog with id: " + id + " not found.");
        }
    }




    @Override
    public List<DogDto> getDogByGender(String gender) {
        return dogMapper.mapp(dogRepository.findAllByGender(gender));
    }

    @Override
    public List<DogDto> getDogByType(String type) {
        return dogMapper.mapp(dogRepository.findAllByGender(type));
    }


}


