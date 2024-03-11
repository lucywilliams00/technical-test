package simplepoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simplepoll.Vote;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
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

    @GetMapping("/get-poll/{pollId}")
    public Resource getPoll(@PathVariable("pollId") Integer pollId) {
        /*
        * if the poll was saved in a database,
        * pollId could be used to get that specific poll
        */
        return pollsJSON;
    }

    @PostMapping("/post-vote")
    public ResponseEntity<?> postVote(@RequestBody PostVoteRequest postVoteRequest) {
        try {
            // System.out.println("Post vote request: poll ID: " + postVoteRequest.getPollId() + ", option ID: " + postVoteRequest.getOptionId());
            // System.out.println(voteRepository.findById(1).get().getPollId());
            Vote vote = voteRepository.findByPollIdAndOptionId(postVoteRequest.getPollId(), postVoteRequest.getOptionId());
            if (vote != null) {
                vote.setVotes(vote.getVotes() + 1);
                voteRepository.save(vote);
                return new ResponseEntity<>("Vote submitted.", HttpStatus.OK);
            } else {
                // System.out.println("Vote is null.");
                return new ResponseEntity<>("Vote does not exist.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // System.out.println("Exception caught.");
            return new ResponseEntity<>("Exception caught.", HttpStatus.BAD_REQUEST);
        }

        // System.out.println(postVoteRequest.getOptionId());
        // return new ResponseEntity<>(postVoteRequest.getOptionId(), HttpStatus.OK);
    }

    @GetMapping("/get-votes/{pollId}")
    public ResponseEntity<?> getVotes(@PathVariable("pollId") Integer pollId) {
        try {
            List<Vote> votes = new ArrayList<>(voteRepository.findAllByPollId(pollId));
            if (votes.isEmpty()) {
                // System.out.println("List is empty.");
                return new ResponseEntity<>("Poll does not exist.", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(votes, HttpStatus.OK);
            }
        } catch (Exception e) {
            // System.out.println("Exception caught.");
            return new ResponseEntity<>("Exception caught.", HttpStatus.BAD_REQUEST);
        }

        // return votesJSON;
    }
}
