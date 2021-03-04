package se.iths.springdemo.controllers;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogGender;
import se.iths.springdemo.entities.DogName;
import se.iths.springdemo.entities.DogType;
import se.iths.springdemo.entities.DogWeight;
import se.iths.springdemo.services.Service;

import java.util.List;

@RestController
//@EnableRetry
public class DogController {

    private Service service;

    //@Autowired
    public DogController(Service service) {
        this.service = service;
    }


    @GetMapping("/dogs")
    public List<DogDto> all() {
        return service.getAllDogs();
    }


    @GetMapping("/dogs/{id}")
    public DogDto one(@PathVariable int id) {
        return service.getOneDog(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Dog " + id + " not found."));
    }


    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public DogDto create(@RequestBody DogDto dog) {
        return service.createDog(dog);
    }


    @DeleteMapping("/dogs/{id}")
    public void delete(@PathVariable int id) {
        service.deleteDog(id);
    }


    @PutMapping("/dogs/{id}")
    public DogDto replace(@RequestBody DogDto dogDto, @PathVariable int id) {
        return service.replaceDog(id, dogDto);
    }


    @PatchMapping("/dogs/{id}/type")
    public DogDto update(@RequestBody DogType dogType, @PathVariable int id) {
        return service.updateDog(id, dogType);
    }


    @PatchMapping("/dogs/{id}/weight")
    public DogDto update(@RequestBody DogWeight dogWeight, @PathVariable int id) {
        return service.updateDog(id, dogWeight);
    }


    @PatchMapping("/dogs/{id}/gender")
    public DogDto update(@RequestBody DogGender dogGender, @PathVariable int id) {
        return service.updateDog(id, dogGender);
    }


    @PatchMapping("/dogs/{id}/name")
    public DogDto update(@RequestBody DogName dogName, @PathVariable int id) {
        return service.updateDog(id, dogName);
    }



//    @PatchMapping(value = "/dogs/{id}", params = "name")
//    public DogDto update(@RequestBody DogName dogName, @PathVariable int id) {
//        return service.updateDog(id, dogName);
//    }

    @GetMapping(value = "/searchdog", params = "name")
    public List<DogDto> searchByName(@RequestParam String name) {
        return service.getDogByName(name);
    }

    @GetMapping(value = "/searchdog", params = "type")
    public List<DogDto> searchByType(@RequestParam String type) {
        return service.getDogByName(type);
    }

    @GetMapping(value = "/searchdog", params = "gender")
    public List<DogDto> searchByGender(@RequestParam String gender) {
        return service.getDogByName(gender);
    }



}
