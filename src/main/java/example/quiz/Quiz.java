package example.quiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Quiz implements Iterable<Question> {
    List<Question> questions = new ArrayList<>();
    String title = "A Quiz";

    public Quiz(String title) {
        this.title = title;
    }

    public Quiz addQuestion(Question question) throws InvalidQuestionException {
        if (!question.isValid()) {
            throw new InvalidQuestionException(question);
        }
        if (!questions.contains(question)) {
            questions.add(question);
        }
        return this;
    }

    public Score getScore() {
        double totalPct = 0.0;
        double totalWeight = 0.0;
        for (Question question : this) {
            Score score = question.getScore();
            totalPct += score.getRawPercentage();
            totalWeight += score.getWeight();
        }
        return new Score().setRawScore(totalPct / totalWeight);
    }

    @Override
    public Iterator<Question> iterator() {
        return new Iterator<>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < questions.size();
            }

            @Override
            public Question next() {
                if (i >= questions.size()) {
                    throw new NoSuchElementException();
                }

                return questions.get(i++);
            }
        };
    }

    public void review() {
        for (Question question : this) {
            System.out.println(question + " " + question.statusMessage());
        }
    }
}