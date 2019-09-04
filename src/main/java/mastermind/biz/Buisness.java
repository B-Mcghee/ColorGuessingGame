package mastermind.biz;

import mastermind.dao.MasterMindDao;
import mastermind.dao.MasterMindImpl;
import mastermind.dto.Game;

import java.util.*;
import java.util.stream.Collectors;

public class Buisness {
    MasterMindDao dao;


    public Buisness() {
        this.dao = new MasterMindImpl();
    }

    public Game startGame(){
        Game game = new Game();
        game.setColorNumber(createNumbers());
        Game id = dao.addGame(game);
        return id;
    }

    public List<Integer> createNumbers(){
        Random rgen = new Random();

        Set<Integer> numbers = new HashSet<>();
        for(int i = 0; numbers.size() < 4; i++){
            int generatedNumber = rgen.nextInt(20);
            numbers.add(generatedNumber);

        }

            return new ArrayList<>(numbers.stream().collect(Collectors.toList()));
    }
}
