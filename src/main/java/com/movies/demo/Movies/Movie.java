package com.movies.demo.Movies;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Movie {

    @Id
    private String  id;
    private String  name;
    private String  description;
    private int     year;
    // private fileType    image; 


    public Movie(String name, String description, int year) {
        this.name = name;
        this.description = description;
        this.year = year;
    }

}
