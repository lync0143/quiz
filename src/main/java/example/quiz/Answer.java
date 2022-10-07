package example.quiz;

import java.util.Objects;

public class Answer {
    private final String answerTxt;

    public Answer(String answerTxt) {
        this.answerTxt = answerTxt;
    }

    public String getAnswerTxt() {
        return this.answerTxt;
    }

    @Override
    public String toString() {
        return getAnswerTxt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(getAnswerTxt(), ((Answer) o).getAnswerTxt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnswerTxt());
    }
}
