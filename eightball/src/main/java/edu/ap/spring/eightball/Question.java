package edu.ap.spring.eightball;

public class Question {
    private String questionText;
    private String answer;

    public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

    public Question(String questionText, String answer){
        this.questionText = questionText;
        this.answer = answer;
	}
	
	public String toString(){
		return questionText + "//" + answer;
	}
}