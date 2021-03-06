package com.example.Zoo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ZooTestIT {
////When I add an animalDto
//		//Then it is in my zoo
//		//Setup
//
//		//Execute/
//		//Test

    @Autowired
    MockMvc mockmvc;
    @Autowired
    ObjectMapper objectmapper;

    @Test
    public void addAnimal() throws Exception {
        AnimalDto animalDto = new AnimalDto("Lion", AnimalType.WALKING,false);
        mockmvc.perform(post("/animal")
                .content(objectmapper.writeValueAsString(animalDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockmvc.perform(get("/animal")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].animalName").value(animalDto.getAnimalName()));
    }

    @Test
    public void feedAnimal() throws Exception {
        AnimalDto animalDto = new AnimalDto("Lion", AnimalType.WALKING, false);
        mockmvc.perform(post("/animal")
                .content(objectmapper.writeValueAsString(animalDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockmvc.perform(post("/animal/Lion/feed")
                .content("Meat")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockmvc.perform(get("/animal/Lion")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("mood").value(true));
        }
        //Rule: Animal moods are unhappy or happy. They are unhappy by default.
}
