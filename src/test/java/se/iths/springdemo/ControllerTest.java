package se.iths.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import se.iths.springdemo.controllers.DogController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ControllerTest {

    // Unit-tests: Testing one thing at a time, in isolation (no databases)

    @Test
    void callingOneWithValidIdReturnsOnePerson() {
        DogController dogController = new DogController(new TestService());
        var dog = dogController.one(1);

        // AssertJ fluent assertions
        assertThat(dog.getId()).isEqualTo(1);
        assertThat(dog.getName()).isEqualTo("Test");
        assertThat(dog.getType()).isEqualTo("Test");
        assertThat(dog.getWeight()).isEqualTo(88);
        assertThat(dog.getGender()).isEqualTo("Test");
    }

    @Test
    void callingOneWithNonValidIdReturnsExceptionWithResponseStatus404() {
        DogController dogController = new DogController(new TestService());
        //var person = personController.one(2L);
        var exception = assertThrows(ResponseStatusException.class,
                                                () -> dogController.one(2));
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }
// given when then



}