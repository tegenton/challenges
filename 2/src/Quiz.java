import java.io.*;
import java.util.ArrayList;

public class Quiz {

    private ArrayList<Question> questionList;
    private BufferedReader reader;
    private int score;

    Quiz(File list) throws IOException{
        try {
            reader = new BufferedReader(new FileReader(list));
        } catch (FileNotFoundException f) {
            printUsage();
            return;
        }
        String temp;
        questionList = new ArrayList<>();
        try {
            while ((temp = reader.readLine()) != null){
                questionList.add(new Question(temp));
            }
        } catch (Exception e) {
            System.out.println("Error reading file!");
            throw e;
        }

    }

    public static void main(String args[]) {
        for (String item : args) {
            System.out.println(item);
        }
        File questions;
        try {
            questions = new File(args[0]);
        } catch (Exception e) {
            printUsage();
            return;
        }
        Quiz q;
        try {
            q = new Quiz(questions);
        } catch (Exception e) {
            return;
        }
        q.runQuiz();
    }

    private void runQuiz() {
        score = 0;
        for (Question question : questionList) {
            if (question.ask())
                score++;
        }
        System.out.println("The quiz is over. Final score: " + score + "/" + questionList.size());
    }

    static void printUsage() {
        System.out.println("Usage: Quiz [question file]");
        System.out.println("Questions should be on individual lines in file in the format:");
        System.out.println("[question]:[answer1]:[answer2]...:[correctAnswerNumber]");
        System.out.println("Correct answer number should use 1 for answer1 and so forth");
    }
}
