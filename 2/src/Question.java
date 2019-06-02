import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Calendar;
import java.util.Scanner;

public class Question {
    private String question;
    private String[] answers;
    private int correctAnswer;

    Question(String info) {
        parseInfo(info);
    }

    private void parseInfo(String info) {
        String[] split = info.split(":");
        question = split[0];
        answers = new String[split.length - 2];
        System.arraycopy(split, 1, answers, 0, split.length - 1 - 1);
        correctAnswer = Integer.parseInt(split[split.length - 1]);
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean ask() {
        System.out.println(question);
        for (int i = 0; i < answers.length; i++)
            System.out.println((i + 1) + ". " + answers[i]);
        System.out.print("Answer: ");
        boolean answered = false;
        Scanner in = new Scanner(System.in);
        int temp = 0;
        while (!answered) {
            try {
                temp = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid number");
                continue;
            }
            if (temp < 1 || temp > answers.length) {
                System.out.println("Not in range");
            }
            else {
                answered = true;
            }
        }
        if (temp == correctAnswer) {
            System.out.println("Correct");
            return true;
        } else {
            System.out.println("Incorrect");
            return false;
        }
    }
}
