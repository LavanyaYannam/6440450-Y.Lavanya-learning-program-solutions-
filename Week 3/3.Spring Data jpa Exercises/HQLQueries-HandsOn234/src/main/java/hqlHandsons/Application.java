package hqlHandsons;

import hqlHandsons.EmployeeService;
import hqlHandsons.AttemptService;
import hqlHandsons.Employee;
import hqlHandsons.Attempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAllPermanentEmployees();
        testGetAttemptDetails(1, 101);
    }

    private void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        var emps = employeeService.getAllPermanentEmployees();
        emps.forEach(e -> {
            LOGGER.info("Employee: {}", e.getName());
            e.getSkillList().forEach(s -> LOGGER.info("Skill: {}", s.getName()));
        });
        LOGGER.info("Average Salary: {}", employeeService.getAvgSalary());
        LOGGER.info("End");
    }

    private void testGetAttemptDetails(int userId, int attemptId) {
        LOGGER.info("Fetching Quiz Attempt Details for userId={}, attemptId={}", userId, attemptId);
        
        Attempt attempt = attemptService.getAttemptDetails(userId, attemptId);
        if (attempt == null) {
            LOGGER.warn("No attempt found for userId={} and attemptId={}", userId, attemptId);
            return;
        }

        Set<AttemptQuestion> questions = attempt.getAttemptQuestions();
        if (questions == null || questions.isEmpty()) {
            LOGGER.warn("No questions found for attemptId={}", attemptId);
            return;
        }

        for (AttemptQuestion aq : questions) {
            Question q = aq.getQuestion();
            if (q != null) {
                System.out.println("Q: " + q.getText());
            } else {
                System.out.println("Q: [question not found]");
            }

            Set<AttemptOption> options = aq.getOptions();
            if (options != null && !options.isEmpty()) {
                for (AttemptOption ao : options) {
                    Option opt = ao.getOption();
                    if (opt != null) {
                        System.out.printf("%d) %s\t%.1f\t%s\n",
                            opt.getId(),
                            opt.getText(),
                            opt.getScore(),
                            ao.isSelected());
                    }
                }
            } else {
                System.out.println("  [No options attempted]");
            }
        }
    }

}
