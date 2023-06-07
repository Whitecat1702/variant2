import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PastSimpleTest {
    public static void main(String[] args) {
        Map<String, String> questions = createQuestions();
        int totalQuestions = questions.size();
        int correctAnswers = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Past Simple Test!");
        System.out.println("Answer the following 5 questions by entering the corresponding letter (a, b, c, or d).");
        System.out.println("Enter 'q' at any time to quit.");

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            String question = entry.getKey();
            String answer = entry.getValue();

            System.out.println("\n" + question);

            String userAnswer;
            while (true) {
                System.out.print("Your answer: ");
                userAnswer = scanner.nextLine();

                if (userAnswer.equals("q")) {
                    System.out.println("Test aborted.");
                    return;
                } else if (userAnswer.matches("[a-d]")) {
                    break;
                } else {
                    System.out.println("Invalid option. Please enter a valid answer (a, b, c, or d).");
                }
            }

            if (userAnswer.equals(answer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Incorrect!");
                System.out.println("The correct answer is: " + answer);
            }
        }

        double score = (double) correctAnswers / totalQuestions * 100;
        System.out.println("\nTest completed!");
        System.out.println("Your score: " + score + "%");

        System.out.print("Enter password to view correct answers (or 'q' to quit): ");
        String password = scanner.nextLine();
        if (password.equals("q")) {
            System.out.println("Program terminated.");
        } else if (password.equals("1111")) {
            System.out.println("\nCorrect answers:");
            for (Map.Entry<String, String> entry : questions.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        } else {
            System.out.println("Invalid password. Program terminated.");
        }
    }

    private static Map<String, String> createQuestions() {
        Map<String, String> questions = new HashMap<>();
        questions.put("1. Choose the correct form of the verb: He _______ to the store yesterday.",
                "b");
        questions.put("a) went\nb) go\nc) goes\nd) will go", "a");
        questions.put("2. They _______ a movie last night.",
                "a");
        questions.put("a) watched\nb) watch\nc) watches\nd) will watch", "a");
        questions.put("3. She _______ her homework after school.",
                "c");
        questions.put("a) did\nb) do\nc) does\nd) will do", "a");
        questions.put("4. We _______ to the beach on vacation.",
                "d");
        questions.put("a) goes\nb) went\nc) going\nd) will go", "b");
        questions.put("5. I _______ a book yesterday.",
                "a");
        questions.put("a) read\nb) reads\nc) reading\nd) will read", "a");
        return questions;
    }
}
