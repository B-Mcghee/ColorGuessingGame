package com.tsg.bullsandcows.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private int id;
    private String randomNumber;
    private boolean finishedGame = false;
    private List<Round> guesses;





}
