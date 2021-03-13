package com.example.Zoo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    public void addAnimal() throws Exception {
        mockmvc.perform(post("/animal")
                .content("")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());


    }



}
