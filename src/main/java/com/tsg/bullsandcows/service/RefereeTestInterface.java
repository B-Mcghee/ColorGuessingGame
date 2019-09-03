package com.tsg.bullsandcows.service;

import com.tsg.bullsandcows.dto.Game;
import com.tsg.bullsandcows.dto.Round;

import java.util.List;

public interface RefereeTestInterface {

    String guessComparison(String number, String guess,Game game);
    int startGame();
    Game getNumber(int id);
    Game displayGame(int id);
    List<Game> getAllGames();
    List<Round> getAllRoundsByGameId(Game game);



}
