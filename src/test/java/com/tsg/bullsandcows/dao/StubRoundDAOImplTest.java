package com.tsg.bullsandcows.dao;

import com.tsg.bullsandcows.dto.Round;
import org.junit.Before;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StubRoundDAOImplTest implements RoundDAO{

    private Map<Integer, Round> roundMap = new HashMap<>();
    private Round round;
    private Round round2;
    private Round round3;
    public StubRoundDAOImplTest(){
         round = new Round(1, "1234", LocalDateTime.of(2019,4,5,12,4), 3);
         round2 = new Round(2, "0567", LocalDateTime.of(2018,7,5,12,4), 1);
         round3 = new Round(3, "1234", LocalDateTime.of(2019,1,5,12,4), 5);


    }
    public StubRoundDAOImplTest(Round round, Round round2, Round round3){
        this.round = round;
        this.round2 = round2;
        this.round3 = round3;
    }

    @Before
    public void setUp() throws Exception {
    }

    @Override
    public Round addRound(Round round, int gameId) {
        return null;
    }

    @Override
    public Round getOneRound(int id) {
        return null;
    }

    @Override
    public List<Round> getAllRounds() {
        roundMap.put(1,round);
        roundMap.put(2,round2);
        roundMap.put(3,round3);
        return new ArrayList<>(roundMap.values());
    }

    @Override
    public void editRound(Round round) {

    }

    @Override
    public void deleteRound(int id) {

    }

    @Override
    public Round deleteAndReturnRound(int id) {
        return null;
    }
}