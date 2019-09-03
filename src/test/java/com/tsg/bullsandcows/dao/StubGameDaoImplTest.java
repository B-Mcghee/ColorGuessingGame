package com.tsg.bullsandcows.dao;

import com.tsg.bullsandcows.dto.Game;
import com.tsg.bullsandcows.dto.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubGameDaoImplTest implements GameDao{
    private RoundDAO testRound = new StubRoundDAOImplTest();
    private Map<Integer, Game> gameMap = new HashMap<>();

    public Game game;
    public Game game2;
    public Game game3;
        public StubGameDaoImplTest(){

            game = new Game(3, "3564", false, null);
            game2 = new Game(5, "1234", false, null);
            game3 = new Game(1, "9876", true, null);
            gameMap.put(3,game);
            gameMap.put(5,game2);
            gameMap.put(1,game3);
        }
        public StubGameDaoImplTest(Game game, Game game2, Game game3){
            this.game = game;
            this.game2 = game2;
            this.game3 = game3;
        }

    @Override
    public Game addGame(Game game) {
        if (gameMap.containsKey(game.getId())){
            return game;
        }
        else return null;
    }

    @Override
    public Game getOneGame(int id) {
            Game game;
        if (gameMap.containsKey(id)){
            game = gameMap.get(id);
            game.setGuesses(getRoundsForGame(game));
            return game;
        }else{
            return null;
        }

    }
    private List<Round> getRoundsForGame(Game game){
            List<Round> gameRounds = new ArrayList<>();
            for (Round i: testRound.getAllRounds()){
                if (i.getGameId()== game.getId()){
                    gameRounds.add(i);
                }
            }
            return gameRounds;
    }

    @Override
    public List<Game> getAllGames() {
            return new ArrayList<>(gameMap.values());
    }

    @Override
    public void editGame(Game Game) {
        gameMap.replace(game.getId(), game);
    }

    @Override
    public void deleteGame(int id) {

    }

    @Override
    public Game deleteAndReturnGame(int id) {
        return null;
    }
}