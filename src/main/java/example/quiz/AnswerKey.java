package example.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerKey {
    private final Map<Answer, Boolean> answerMap = new HashMap<>();
    private List<Answer> answerOrder;


    AnswerKey() {}
    AnswerKey(Map<Answer, Boolean> answerMap) {
        this();
        putAnswers(answerMap);
    }

    public AnswerKey putAnswer(String answerTxt, boolean correct) {
        getAnswerMap().put(new Answer(answerTxt), correct);
        setAnswerOrder();
        return this;
    }

    public AnswerKey putAnswers(Map<Answer, Boolean> answerMap) {
        getAnswerMap().putAll(answerMap);
        setAnswerOrder();
        return this;
    }

    public void setAnswerOrder() {
        try {
            setAnswerOrder(getAnswerMap().keySet());
        } catch (AnswerNotFoundException ex) {
            System.err.println("Unexpected AnswerNotFoundException in setAnswerOrder()");
            System.exit(1);
        }
    }

    public Map<Answer, Boolean> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerOrder(Iterable<Answer> answers) throws AnswerNotFoundException {
        ArrayList<Answer> order = new ArrayList<>();
        for (Answer answer: answers) {
            if (answerMap.get(answer) == null) {
                throw new AnswerNotFoundException(answer.toString());
            }
            order.add(answer);
        }
        this.answerOrder = order;
    }

    public List<Answer> getAnswerOrder() {
        return answerOrder;
    }

    public boolean isValid() {
        Map<Answer, Boolean> answerMap = getAnswerMap();
        return answerMap.size() > 0 && answerMap.values().contains(true);
    }

    public boolean isCorrect(Answer answer) {
        if (answerMap.get(answer) == null) return false;
        return answerMap.get(answer) == true;
    }
}
