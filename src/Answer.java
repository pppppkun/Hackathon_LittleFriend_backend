public class Answer {

    private String answer;

    private int questionID;

    private int answersID;

    private int value = 10;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Answer(String answer, int questionID, int answersID) {
        this.answer = answer;
        this.questionID = questionID;
        this.answersID = answersID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getAnswersID() {
        return answersID;
    }

    public void setAnswersID(int answersID) {
        this.answersID = answersID;
    }
}
