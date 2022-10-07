package example.quiz;

import java.util.Scanner;

public class MultipleChoiceQuestion extends Question {
    private Score score = new Score();
    public MultipleChoiceQuestion(String questionTxt) {
        super(questionTxt);
    }
    @Override
    public AnswerState handleAnswer(Scanner scanner) {
        AnswerState answerState = super.handleAnswer(scanner);
        if (!answerState.getAnswer().getAnswerTxt().equals("q")) {
            answerState.setDone(false);
        }
        return answerState;
    }

    @Override
    public Score getScore() {
        AnswerKey answerKey = getAnswerKey();
        Score score = this.score;
        int totalCorrect = 0;
        for (Answer answer : getAnswers()) {
            if (answerKey.isCorrect(answer)) {
                totalCorrect += 1;
            }
        }
        score.setMaxScore(getAnswerKey().getAnswerOrder().stream().mapToInt(ans -> (getAnswerKey().getAnswerMap().get(ans) ?  1 : 0)).sum());
        score.setRawScore(totalCorrect);
        return score;
    }
}
