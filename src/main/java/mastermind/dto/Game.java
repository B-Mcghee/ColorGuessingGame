package mastermind.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private int id;
    private List<Round> guesses;
    private List<Integer> colorNumber;


}
