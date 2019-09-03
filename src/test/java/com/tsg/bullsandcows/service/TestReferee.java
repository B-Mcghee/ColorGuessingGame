package com.tsg.bullsandcows.service;

import com.tsg.bullsandcows.dao.GameDao;
import com.tsg.bullsandcows.dao.RoundDAO;
import com.tsg.bullsandcows.dao.StubGameDaoImplTest;
import com.tsg.bullsandcows.dao.StubRoundDAOImplTest;
import com.tsg.bullsandcows.dto.Game;
import com.tsg.bullsandcows.dto.Round;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class TestReferee {


    private Referee ref;

    public TestReferee() {


        RoundDAO roundList = new StubRoundDAOImplTest();
        GameDao gameDao = new StubGameDaoImplTest();
        ref = new Referee(roundList, gameDao);

    }

    @Test
    public void testGuessComparison() {

       int id = 3;
       String guess = "2345";
       Game game = ref.getNumber(3);

        String response = ref.guessComparison(game.getRandomNumber(), guess, game);
        Assert.assertEquals("The returned string match should be","E: 0 P: 3",response);

        guess = "3654";
        response = ref.guessComparison(game.getRandomNumber(), guess, game);
        Assert.assertEquals("The returned string match should be","E: 2 P: 2",response);

        guess = "3564";
        response = ref.guessComparison(game.getRandomNumber(), guess, game);
        Assert.assertEquals("The returned string match should be","You've gotten all numbers in the correct Position!",response);

    }

    @Test
    public void testStartGame() {
        Random rGen = new Random();

        for (int i = 0; i < 10;  i++) {
        int digit1 = rGen.nextInt(10);
        int digit2 = rGen.nextInt(10);
        int digit3 = rGen.nextInt(10);
        int digit4 = rGen.nextInt(10);
        while (digit2 == digit1) {
            digit2 = rGen.nextInt(10);
        }
        while (digit3 == digit1 || digit3 == digit2) {
            digit3 = rGen.nextInt(10);
        }
        while (digit4 == digit1 || digit4 == digit2 || digit4 == digit3) {
            digit4 = rGen.nextInt(10);
        }
        String number = "" + digit1 + digit2 + digit3 + digit4;

            Set<Character> set = new HashSet<>();
            for(Character j: number.toCharArray()){
                if (!set.add(j)){
                    Assert.fail("There is a duplicate");
                }
            }


        }

    }

    @Test
    public void startGameFailWithDuplicate() {
        Random rGen = new Random();
        for (int i = 0; i < 10;  i++) {
            int digit1 = 4;
            int digit2 = 4;
            int digit3 = rGen.nextInt(10);
            int digit4 = rGen.nextInt(10);
//            while (digit2 == digit1) {
//                digit2 = rGen.nextInt(10);
//            }
            while (digit3 == digit1 || digit3 == digit2) {
                digit3 = rGen.nextInt(10);
            }
            while (digit4 == digit1 || digit4 == digit2 || digit4 == digit3) {
                digit4 = rGen.nextInt(10);
            }

            String number = "" + digit1 + digit2 + digit3 + digit4;

            Set<Character> set = new HashSet<>();
            for(Character j: number.toCharArray()){
                if (!set.add(j)){
                    Assert.fail("There is a duplicate");
                }
            }


        }

    }

    @Test
    public void TestDisplayNullUnFinishedGame() {
        int id = 3;
        Game compare = ref.getNumber(3);

        Assert.assertEquals("Guess should return back since a pass through method", "3564", compare.getRandomNumber());

        Game game = ref.displayGame(3);
        Assert.assertNull("Guess should return back null because of it is unfinished ",
                game.getRandomNumber());


        Game finishedGame = ref.displayGame(1);
        Assert.assertEquals("Game is finished so should return back the guess", "9876", finishedGame.getRandomNumber());
    }

    @Test
    public void TestGetAllRoundsByGameId() {
        Game game = ref.getNumber(3);

        List<Round> roundsForGame = game.getGuesses();

        Assert.assertTrue("List of rounds should not be empty",!roundsForGame.isEmpty() );

        Game game2 = ref.getNumber(5);
        List<Round> roundsForGame2 = game2.getGuesses();
        Assert.assertTrue("List of rounds for game2 should not be empty",!roundsForGame2.isEmpty() );

    }
}