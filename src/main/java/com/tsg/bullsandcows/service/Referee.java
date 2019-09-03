package com.tsg.bullsandcows.service;


import com.tsg.bullsandcows.dao.GameDao;
import com.tsg.bullsandcows.dao.RoundDAO;
import com.tsg.bullsandcows.dto.Game;
import com.tsg.bullsandcows.dto.Round;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
@AllArgsConstructor
public class Referee {

    @Autowired
    private RoundDAO roundList;
    @Autowired
    private GameDao gameDao;


    public String guessComparison(String number, String guess, Game game) {
        if (game.isFinishedGame()){
            return "This game has already been completed, the winning answer was " + game.getRandomNumber() + ", " +
                    "start a new game to play again";
        }
        if (guess.length() != 4) {
            return "That does not fit the requirements of a 4 digit number ";
        }
        try {
            Integer.parseInt(guess);
        } catch (NumberFormatException ex) {
            return "That is not a valid entry";
        }
        int exact = 0;
        int partial = 0;
        Round newRound = new Round();
        newRound.setUserGuess(guess);
        newRound.setGuessTime(LocalDateTime.now().withNano(0));
        newRound.setGameId(game.getId());
        roundList.addRound(newRound, game.getId());


        Set<Character> set = new HashSet<>();
        for(Character j: number.toCharArray()){
            set.add(j);
        }

        for (int i = 0; i < number.length(); i++) {
                if (guess.charAt(i) == number.charAt(i)) {
                    exact++;
                }else if(set.contains(guess.charAt(i)))  {
                    partial++;
                }
            }




            game.setGuesses(getAllRoundsByGameId(game));

        if (exact == 4) {
            game.setFinishedGame(true);
            gameDao.editGame(game);
            return "You've gotten all numbers in the correct Position!";
        } else {
            return "E: " + exact + " P: " + partial;
        }
    }

    public int startGame() {

        Game game = new Game();
        Random rGen = new Random();

        Set<String> set = new HashSet<>();
        int digit = 0;

        while(set.size()<4){
            digit = rGen.nextInt(10);
            String num = Integer.toString(digit);
            set.add(num);
        }

        String number = "";
        for (String i: set){
            number +=i;
        }

        game.setRandomNumber(number);
        Game withId = gameDao.addGame(game);
        return withId.getId();
    }


    public Game getNumber(int id) {
        Game game = gameDao.getOneGame(id);
        return game;
    }

    public Game displayGame(int id) {
        Game game = gameDao.getOneGame(id);
        if (!game.isFinishedGame()) {
            game.setRandomNumber(null);
            return game;
        }
        return game;
    }

    public List<Game> getAllGames() {
        List<Game> allGames = gameDao.getAllGames();

        for (Game aGame : allGames) {
            if (!aGame.isFinishedGame()) {
                aGame.setRandomNumber(null);
            }
        }
        return allGames;
    }

    public List<Round> getAllRoundsByGameId(Game game) {
        List<Round> gameRounds = new ArrayList<>();
        for (Round i: roundList.getAllRounds()){
            if (i.getGameId() == game.getId()){
                gameRounds.add(i);
            }
        }
       return gameRounds;
    }

}
