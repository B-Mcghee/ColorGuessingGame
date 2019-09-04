package mastermind.dao;

import mastermind.dto.Game;
import mastermind.dto.RandomNumber;
import mastermind.dto.Round;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class MasterMindImpl implements MasterMindDao {
    Map<Integer, Game> gameMap = new HashMap<>();
    Map<Integer, Round> roundMap = new HashMap<>();
    Map<Integer, RandomNumber> randomNumberMap = new HashMap<>();

//    @Getter
//    JdbcTemplate heySQL;

    @Override
    public Game addGame(Game game) {
        game.setId(getGameId());
        gameMap.put(game.getId(), game);
        return game;
    }

    public int getGameId(){
        int max = 0;
        for(int id: gameMap.keySet()){
            if(id > max){
                max = id;
            }
        }
        return max + 1;
    }
    @Override
    public Game getAGame(int gameId) {
        return gameMap.get(gameId);
    }

    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(gameMap.values());
    }

    @Override
    public void updateGame(int gameId, Game game) {
        gameMap.replace(gameId,game);
    }

    @Override
    public void removeGame(int gameid) {
        gameMap.remove(gameid);
    }

    @Override
    public Round addRound(Round round) {
        return roundMap.put(round.getId(), round);
    }



    @Override
    public Round getARound(int roundId) {
        return roundMap.get(roundId);
    }

    @Override
    public List<Round> getAllRounds() {
        return new ArrayList<>(roundMap.values());
    }

    @Override
    public void updateRound(int roundId, Round round) {
        roundMap.replace(roundId, round);
    }

    @Override
    public void removeRound(int roundId) {
        roundMap.remove(roundId);
    }

    @Override
    public RandomNumber addNumber(RandomNumber randomNumber) {
        return randomNumberMap.put(randomNumber.getId(), randomNumber);
    }

    @Override
    public RandomNumber getANumber(int id) {
        return randomNumberMap.get(id);
    }

    @Override
    public List<RandomNumber> getAllNumbers() {
        return new ArrayList<>(randomNumberMap.values());
    }

    @Override
    public void updateRandomNumber(int id, RandomNumber randomNumber) {
        randomNumberMap.replace(id, randomNumber);
    }

    @Override
    public void removeNumber(int id) {
        randomNumberMap.remove(id);
    }
}
