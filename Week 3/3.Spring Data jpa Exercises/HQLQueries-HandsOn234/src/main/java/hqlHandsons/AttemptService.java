package hqlHandsons;

import hqlHandsons.Attempt;
import hqlHandsons.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {

    @Autowired
    private AttemptRepository repo;

    public Attempt getAttemptDetails(int userId, int attemptId) {
        return repo.getAttemptDetail(userId, attemptId);
    }
}
