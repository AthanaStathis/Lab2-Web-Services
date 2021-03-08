package se.iths.springdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import se.iths.springdemo.controllers.DogController;
import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.DogAge;
import se.iths.springdemo.services.ServiceInterface;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DogController.class)
public class MvcTest {

    //@Autowired
    @MockBean
    ServiceInterface service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonmapper;

    @Test
    void UrlDogs_ReturnsAllDogs() throws Exception {
        Mockito.when(service.getAllDogs()).thenReturn(List.of(new DogDto(1,"DogName","DogType",
                12, "DogGender")));
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/dogs")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }


    @Test
    void SearchByType_ReturnsDogsOfSpecificType() throws Exception {
        Mockito.when(service.getDogByType("DogType")).thenReturn(List.of(new DogDto(1,"DogName","DogType",
                12, "DogGender")));
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/searchdog?type=DogType")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }


    @Test
    void SearchByGender_ReturnsDogsOfSpecificGender() throws Exception {
        Mockito.when(service.getDogByType("DogGender")).thenReturn(List.of(new DogDto(1,"DogName","DogType",
                12, "DogGender")));
        var result = mockMvc.perform(MockMvcRequestBuilders.get("/searchdog?gender=DogGender")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }


    @Test
    void calling_POST_SaveDogAndReturnSavedDog() throws Exception {
        var dogDto = new DogDto(1,"DogName","DogType",12,"DogGender");
        Mockito.when(service.createDog(dogDto)).thenReturn(dogDto);
        var result = mockMvc.perform(MockMvcRequestBuilders.post("/dogs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonmapper.writeValueAsBytes(dogDto))
                .accept(MediaType.APPLICATION_JSON)).andReturn();


        assertThat(result.getResponse().getStatus()).isEqualTo(201);

    }


    @Test
    void calling_PUT_ReplacesDog() throws Exception {
        var dogDto = new DogDto(20,"DogName","Dogtype",12, "DogGender");
        var newDog = new DogDto(30, "NewDogName", "NewDogType", 13,
                                        "NewDogGender");

        Mockito.when(service.replaceDog(20, dogDto)).thenReturn(newDog);

        var result = mockMvc.perform(MockMvcRequestBuilders.put("/dogs/{id}",20)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonmapper.writeValueAsBytes(newDog))
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }



    @Test
    void calling_PATCH_UpdateDogsAge() throws Exception {
        var dogDto = new DogDto(20,"DogName","Dogtype",12, "DogGender");
        DogAge dogAge = new DogAge();
        dogAge.age = 15;

        Mockito.when(service.updateDog(20, dogAge)).thenReturn(dogDto);

        var result = mockMvc.perform(MockMvcRequestBuilders.patch("/dogs/{id}/age",20)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonmapper.writeValueAsBytes(dogAge))
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }


    @Test
    void calling_DELETE_DeletesDog() throws Exception {
        var result = mockMvc.perform(MockMvcRequestBuilders.delete("/dogs/{id}",20))
                .andExpect(status().isOk()).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }


}
