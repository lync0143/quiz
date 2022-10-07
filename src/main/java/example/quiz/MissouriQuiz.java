package example.quiz;

public class MissouriQuiz extends Quiz {
    public MissouriQuiz() {
        super("Missouri Facts");
        int i = 1;
        // Capital City
        Question question = new Question("What is the capital of Missouri?")
                .setNumber(i++)
                .addAnswer("Columbia", false)
                .addAnswer("Jefferson City", true)
                .addAnswer("Kansas City", false)
                .addAnswer("St. Louis", false);
        try {
            addQuestion(question);
        } catch (InvalidQuestionException ex) {
            System.out.println("unexpected InvalidQuestionException in MissouriQuiz()");
        }
        // Statehood
        question = new Question("When did Missouri become a state?")
                .setNumber(i++)
                .addAnswer("1492", false)
                .addAnswer("1776", false)
                .addAnswer("1821", true)
                .addAnswer("1900", false);
        try {
            addQuestion(question);
        } catch (InvalidQuestionException ex) {
            System.out.println("unexpected InvalidQuestionException in MissouriQuiz()");
        }

        // Motto
        question = new MultipleChoiceQuestion("Missouri is known as the ____ State.")
                .setNumber(i++)
                .addAnswer("Cave", true)
                .addAnswer("Treasure", false)
                .addAnswer("Green Mountain", false)
                .addAnswer("Show Me", true);
        try {
            addQuestion(question);
        } catch (InvalidQuestionException ex) {
            System.out.println("unexpected InvalidQuestionException in MissouriQuiz()");
        }
    }
}
