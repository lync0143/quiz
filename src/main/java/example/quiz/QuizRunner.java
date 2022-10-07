package example.quiz;

public class QuizRunner {
    public static void main(String... args) {
        Quiz missouriQuiz = new MissouriQuiz();
        for (Question question : missouriQuiz) {
            question.prompt();
        }
        System.out.println();
        missouriQuiz.review();
        System.out.println("\nQuiz Score: " + missouriQuiz.getScore().getPercentage() + "%");
    }
}
