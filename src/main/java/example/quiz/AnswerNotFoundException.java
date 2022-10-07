package example.quiz;

public class AnswerNotFoundException extends Throwable {
    public AnswerNotFoundException(String message) {
        super(message);
    }
}
