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
        return service.getOne(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));
    }


    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public DogDto create(@RequestBody DogDto dog) {
        return service.createDog(dog);
    }


    @DeleteMapping("/dogs/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }


    @PutMapping("/dogs/{id}")
    public DogDto replace(@RequestBody DogDto dogDto, @PathVariable int id) {
        return service.replace(id, dogDto);
    }

    @PatchMapping("/dogs/{id}")
    public DogDto update(@RequestBody DogType dogType, @PathVariable int id) {
        return service.update(id, dogType);
    }


    @PatchMapping("/dogs/{id}")
    public DogDto update(@RequestBody DogWeight dogWeight, @PathVariable int id) {
        return service.update(id, dogWeight);
    }

    @PatchMapping("/dogs/{id}")
    public DogDto update(@RequestBody DogGender dogGender, @PathVariable int id) {
        return service.update(id, dogGender);
    }

    @PatchMapping("/dogs/{id}")
    public DogDto update(@RequestBody DogName dogName, @PathVariable int id) {
        return service.update(id, dogName);
    }
}
