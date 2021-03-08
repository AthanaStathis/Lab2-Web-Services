package se.iths.springdemo.controllers;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogAge;
import se.iths.springdemo.services.ServiceInterface;

import java.util.List;

@RestController
//@EnableRetry
public class DogController {

    private ServiceInterface serviceInterface;

    //@Autowired
    public DogController(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }


    @GetMapping("/dogs")
    public List<DogDto> all() {
        return serviceInterface.getAllDogs();
    }



    @GetMapping("/dogs/{id}")
    public DogDto one(@PathVariable int id) {
        return serviceInterface.getOneDog(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dog " + id + " not found."));
    }


    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public DogDto create(@RequestBody DogDto dog) {
        return serviceInterface.createDog(dog);
    }


    @DeleteMapping("/dogs/{id}")
    public void delete(@PathVariable int id) {
        serviceInterface.deleteDog(id);
    }


    @PutMapping("/dogs/{id}")
    public DogDto replace(@RequestBody DogDto dogDto, @PathVariable int id) {
        return serviceInterface.replaceDog(id, dogDto);
    }


    @PatchMapping("/dogs/{id}/age")
    public DogDto update(@RequestBody DogAge dogAge, @PathVariable int id) {
        return serviceInterface.updateDog(id, dogAge);
    }


//    @PatchMapping(value = "/dogs/{id}", params = "name")
//    public DogDto update(@RequestBody DogName dogName, @PathVariable int id) {
//        return service.updateDog(id, dogName);
//    }


    @GetMapping(value = "/searchdog", params = "type")
    public List<DogDto> searchByType(@RequestParam String type) {
        return serviceInterface.getDogByType(type);
    }

    @GetMapping(value = "/searchdog", params = "gender")
    public List<DogDto> searchByGender(@RequestParam String gender) {
        return serviceInterface.getDogByGender(gender);
    }



}
