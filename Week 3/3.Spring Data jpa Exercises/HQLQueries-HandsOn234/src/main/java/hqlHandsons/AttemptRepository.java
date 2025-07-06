package hqlHandsons;

import hqlHandsons.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    // HQL: Fetch quiz attempt with full join on user, question, options, etc.
    @Query("SELECT a FROM Attempt a " +
           "JOIN FETCH a.user " +
           "JOIN FETCH a.attemptQuestions aq " +
           "JOIN FETCH aq.question q " +
           "JOIN FETCH aq.options o " +
           "WHERE a.id = :attemptId AND a.user.id = :userId")
    Attempt getAttemptDetail(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
