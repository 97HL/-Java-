package User;

import java.util.List;

public class Question {
	private String title;// 题干
	String answerA;
	String answerB;
	String answerC;
	String answerD;
	private String answer;// 正确答案

	public Question(String title, String answerA,String answerB,String answerC,String answerD, String answer){
		this.title = title;
		this.answerA=answerA;
		this.answerB=answerA;
		this.answerC=answerA;
		this.answerD=answerA;
		this.answer = answer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	

}
