public class Answer {

    private String answer;

    private String questionID;

    private String answersID;

    public Answer(String answer, String questionID, String answersID) {
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

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getAnswersID() {
        return answersID;
    }

    public void setAnswersID(String answersID) {
        this.answersID = answersID;
    }
}
