package com.tsg.bullsandcows.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round {
    private int id;
    private String userGuess;
    private LocalDateTime guessTime;
    private int gameId;

}

