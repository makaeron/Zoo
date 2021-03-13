package com.example.Zoo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@RestController
public class AnimalController {
    ArrayList<AnimalDto> animalDto = new ArrayList<AnimalDto>();

    @PostMapping("animal")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimal(@RequestBody AnimalDto animal){
        animalDto.add(animal);
    }

    @GetMapping("animal")
    public  ArrayList<AnimalDto> getAnimal(){
        //return "[{}]";
        return this.animalDto;
    }



}
