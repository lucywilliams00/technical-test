package simplepoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simplepoll.Vote;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class Controller {
    @Value("classpath:/poll.json")
    Resource pollsJSON;

    @Value("classpath:/votes.json")
    Resource votesJSON;

    @Autowired
    VoteRepository voteRepository;

    @GetMapping("/get-poll")
    public Resource getPoll() {
        return pollsJSON;
    }

    @PostMapping("/post-vote/{vote}")
    public ResponseEntity<Integer> postVote(@PathVariable("vote") Integer vote) {
        return new ResponseEntity<>(vote, HttpStatus.OK);

        /*
        Optional<Vote> newVote = voteRepository.findByPollIdAndOptionId(1, vote);
        if (newVote.isPresent()) {
            Integer currentVotes = newVote.get().getVotes();
            newVote.setVotes(currentVotes + 1);
            voteRepository.save(newVote);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        */
    }

    @GetMapping("/get-votes/{pollId}")
    public Resource getVotes(@PathVariable("pollId") Integer pollId) {
        return votesJSON;

        /*
        try {
            List<Vote> options = new ArrayList<Vote>(voteRepository.findByPollId(1));
            return new ResponseEntity<>(votes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        */
    }
}
