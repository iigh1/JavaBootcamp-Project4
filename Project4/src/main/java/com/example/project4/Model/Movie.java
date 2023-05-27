package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 2 , max = 10, message = "name should be more than 2 letters")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @NotEmpty(message = "genre cannot be empty")
    @Column(columnDefinition = "varchar(20) not null check(genre='Drama' or genre='Action' or genre='Comedy') ")
    private String genre;

    @NotNull(message = "rating cannot be empty")
    @Size(min =  1, max =5 , message = "the rating should be between 1-5")
    @Column(columnDefinition = "int not null")
    private Integer rating;

    @NotNull(message = "duration cannot be empty")
    @Size(min= 70 , max = 100 , message = " duration should be more than 60")
    @Column(columnDefinition = "int not null")
    private Integer duration;

    @NotNull(message = "directorId cannot be empty")
    @Size(min = 4, max = 8, message = "directorId should be more than 3")
    @Column(columnDefinition = "int not null")
    private Integer directorId;
}
