package se.iths.springdemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogEmail;
import se.iths.springdemo.services.Service;

import java.util.List;

@RestController
public class DogController {

    private Service service;

    //@Autowired
    public DogController(Service service) {
        this.service = service;
    }

    /*@GetMapping("/hello")
    public Optional<Person> sayHello() {
        personRepository.save(new Person(0,"Kalle", "kalle@ankeborg.se"));
        return personRepository.findById(1L);
    }*/

    @GetMapping("/dogs")
    public List<DogDto> all() {
        return service.getAllDogs();
    }

    // Använder response-entity för att få 200 eller 404
    /*@GetMapping("/persons/{id}")
    public ResponseEntity<Person> one(@PathVariable Long id) {
        var result = personRepository.findById(id);
        if (result.isPresent())
            return new ResponseEntity<Person>(result.get(), HttpStatus.OK);
        return new ResponseEntity("User with id " + id + "not found.", HttpStatus.NOT_FOUND);
    }*/

    @GetMapping("/dogs/{id}")
    public DogDto one(@PathVariable Long id) {

        // Optional object could be used so as to get this specific "blanc" person instead of null
        // Optional<Person> optionalPerson = Optional.of(new Person(1," "," "));
        return service.getOne(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));
        // ifall man vill inte kasta en exception då kan man använda efter findById() .orElse(new Person())
        // för att kasta en person istället

        /*
        return result.orElseThrow(()-> throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Id " + id + " not found."); // Return a person if it exists otherwise throw exception.
                                             // Alternatively:
                                            //if (result.isPresent())
                                            //    return result.get();
                                            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id " + id + " not found.");
        */
    }

    // POST request - add a person (json) and return it to client that made the request
    //Returns 200 instead of 201 that it should (check slide HTTP Verb)
    //@PostMapping("/persons")
    //public Person create(@RequestBody Person person) {
    //    return personRepository.save(person);
    //}

    // POST request - add a person (json) and return it to client that made the request
    // Returns 201(check slide HTTP Verb)
    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public DogDto create(@RequestBody DogDto dog) {
        return service.createDog(dog);
    }

    @DeleteMapping("/dogs/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/dogs/{id}")
    public DogDto replace(@RequestBody DogDto dogDto, @PathVariable Long id) {
        return service.replace(id, dogDto);
    }

    @PatchMapping("/dogs/{id}")
    public DogDto update(@RequestBody DogEmail dogEmail, @PathVariable Long id) {
        return service.update(id, dogEmail);
    }
}
