package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;
	
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	private String getUserAnswer() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	public int getTotalPoints() {
		int sum = 0;
		for(Question q : questions) {
			sum += q.getPoints();
		}
		return sum;
	}
	
		public void takeQuiz() {
		    int totalPointsEarned = 0;

		    // Iterate through each question in the quiz
		    for (Question question : questions) {
		        // Display the question prompt
		        question.displayPrompt();
		        
		        // Get the user's answer using the provided method
		        String userAnswer = getUserAnswer();

		        // Check the user's answer and calculate points earned
		        int pointsEarned = question.checkAnswer(userAnswer);
		        totalPointsEarned += pointsEarned;

		        // Display the points earned for this question
		        System.out.println("Points earned for this question: " + pointsEarned);
		    }

		    // After all questions, display the total points earned and maximum points available
		    int totalPointsAvailable = getTotalPoints();
		    System.out.println("Quiz complete!");
		    System.out.println("Total points earned: " + totalPointsEarned + " out of " + (totalPointsAvailable+1));
		}

	
	
	public static void main(String[] args) {
		Question q = new Question("What number studio is this?", "8", 2);

		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);

		choices = new String[] {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);

		Question[] questions = {q, multipleChoice, selectAll}; //create and add more questions!
		
		Quiz studio8quiz = new Quiz(questions);
		studio8quiz.takeQuiz();
	}
}
