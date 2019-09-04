package mastermind.dao;

import mastermind.dto.Game;
import mastermind.dto.RandomNumber;
import mastermind.dto.Round;

import java.util.List;

public interface MasterMindDao {

    Game addGame(Game game);
    Game getAGame(int gameId);
    List<Game> getAllGames();
    void updateGame(int gameId, Game game);
    void removeGame(int gameid);

    Round addRound(Round round);
    Round getARound(int roundId);
    List<Round> getAllRounds();
    void updateRound(int roundId, Round round);
    void removeRound(int roundId);

    RandomNumber addNumber(RandomNumber randomNumber);
    RandomNumber getANumber(int id);
    List<RandomNumber> getAllNumbers();
    void updateRandomNumber(int id, RandomNumber randomNumber);
    void removeNumber(int id);
}
