package mastermind.ops;

import mastermind.biz.Buisness;
import mastermind.dto.Game;
import mastermind.dto.Round;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mastermind")
public class MasterMindController {
    Buisness biz;

    public MasterMindController() {
        this.biz = new Buisness();
    }

    @GetMapping("/startgame")
    public Game startGame(){

        Game game = biz.startGame();
        return game;
    }

    @RequestMapping(value = "/userGuess/{gameid}",method = RequestMethod.POST)
    @ResponseBody
    public int userGuess(@PathVariable int gameid){

        Round newRound = new Round();


        return gameid;
    }
}
