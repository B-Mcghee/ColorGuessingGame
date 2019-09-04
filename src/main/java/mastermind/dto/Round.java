package mastermind.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round {
    private int id;
    private List<Integer> userGuess;
    private boolean winTheGame;
    private int gameId;


}
