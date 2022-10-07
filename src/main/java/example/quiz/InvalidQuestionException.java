package example.quiz;

public class InvalidQuestionException extends Throwable {
    public InvalidQuestionException(Question question) {
        super(question.toString());
    }
}
