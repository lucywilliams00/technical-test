package simplepoll;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
    List<Vote> findAllByPollId(Integer pollId);
    Vote findByPollIdAndOptionId(Integer pollId, Integer optionId);
}
