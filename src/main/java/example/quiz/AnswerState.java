package example.quiz;

public class AnswerState {
    private boolean valid = false;
    private boolean done = false;
    private Answer answer;

    public boolean isValid() {
        return valid;
    }

    public boolean isDone() {
        return done;
    }

    public Answer getAnswer() {
        return this.answer;
    }

    public AnswerState setValid(boolean valid) {
        this.valid = valid;
        return this;
    }

    public AnswerState setDone(boolean done) {
        this.done = done;
        return this;
    }

    public AnswerState setAnswer(String answer) {
        this.answer = new Answer(answer);
        return this;
    }

    public AnswerState setAnswer(Answer answer) {
        this.answer = new Answer(answer.toString());
        return this;
    }
}
