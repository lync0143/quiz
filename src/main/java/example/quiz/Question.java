package example.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Question {
    private int number;
    private String questionTxt;
    private AnswerKey answerKey = new AnswerKey();
    private final List<Answer> answers = new ArrayList<>();

    private Score score = new Score();

    public Question(String questionTxt) {
        setQuestionTxt(questionTxt);
    }

    public int getNumber() {
        return number;
    }

    public String getQuestionTxt() {
        return questionTxt;
    }

    public AnswerKey getAnswerKey() {
        return answerKey;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Question setNumber(int number) {
        this.number = number;
        return this;
    }

    public Question setQuestionTxt(String questionTxt) {
        this.questionTxt = questionTxt;
        return this;
    }

    public Question addAnswer(String answerTxt, boolean correct) {
        getAnswerKey().putAnswer(answerTxt, correct);
        return this;
    }

    public void prompt() {
        display();
        Scanner scanner = new Scanner(System.in);
        AnswerState answerState = handleAnswer(scanner);
        while (!answerState.isDone()) {
            display();
            answerState = handleAnswer(scanner);
        }
    }

    public AnswerState handleAnswer(Scanner scanner) {
        AnswerState answerState = new AnswerState();
        answerState.setAnswer(scanner.nextLine());
        String answerStr = answerState.getAnswer().toString();
        if (answerStr.equals("q")) {
            return answerState.setDone(true);
        }
        List<Answer> allowedAnswers = getAnswerKey().getAnswerOrder();
        Answer answer = answerState.getAnswer();
        List<Answer> submittedAnswers = getAnswers();
        int i = allowedAnswers.indexOf(answer);
        if (i >= 0) {
            answerState.setValid(true).setDone(true);
        }
        if (!answerState.isValid() && answerStr.matches("^\\d+$")) {
            i = Integer.parseInt(answerStr) - 1;
            if (i >= 0 && i < allowedAnswers.size()) {
                answer = allowedAnswers.get(i);
                answerState.setAnswer(answer).setValid(true).setDone(true);
            }
        }
        if (answerState.isValid()) {
            getAnswers().add(answer);
        } else {
            System.out.println();
            System.out.println("Invalid answer: " + answerState.getAnswer());
            System.out.println("Please enter a valid answer.");
        }
        return answerState;
    }

    public void display() {
        System.out.println();
        if (getNumber() > 0) System.out.print(getNumber() + " ");
        System.out.println(getQuestionTxt());
        List<Answer> possibleAnswers = getAnswerKey().getAnswerOrder();
        for (int i = 0; i < possibleAnswers.size(); i++) {
            Answer possibleAnswer = possibleAnswers.get(i);
            String selectedIndicator = "";
            if (getAnswers().contains(possibleAnswer)) {
                selectedIndicator = " *";
            }
            System.out.println("    " + (i + 1) + ". " + possibleAnswer + selectedIndicator);
        }
        System.out.print("Enter your answer (1-" + possibleAnswers.size() + " or 'q'): ");
    }

    @Override
    public String toString() {
        return this.getQuestionTxt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(getQuestionTxt(), question.getQuestionTxt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestionTxt());
    }

    public Question setScore(Score score) {
        this.score = score;
        return this;
    }

    public Score getScore() {
        AnswerKey answerKey = getAnswerKey();
        Score score = this.score;
        for (Answer answer : getAnswers()) {
            if (answerKey.isCorrect(answer)) {
                score.setRawScore(1);
            } else {
                score.setRawScore(0);
                return score;
            }
        }
        return score;
    }

    public boolean isValid() {
        return getAnswerKey().isValid();
    }

    public boolean skipped() {
        return getAnswers().size() == 0;
    }

    public String statusMessage() {
        if (skipped()) return "skipped";
        double pct = getScore().getPercentage();
        if (pct == 0.0) {
            return "incorrect";
        } else if (pct < 100) {
            return "partial";
        } else {
            return "correct";
        }
    }
}