package com.example.Zoo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto {

    String  animalName;
    String animalType;
    Boolean mood;
    public AnimalDto(String animalName, AnimalType walking, Boolean mood) {



    }
}
