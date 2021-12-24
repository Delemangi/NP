package lab8.Kviz;

import java.util.*;

public class TriviaData {
    private ArrayList<TriviaQuestion> data;

    public TriviaData() {
        data = new ArrayList<TriviaQuestion>();
    }

    public void addQuestion(String q, String a, int v, int t) {
        TriviaQuestion question = new TriviaQuestion(q, a, v, t);
        data.add(question);
    }

    public void showQuestion(int index) {
        TriviaQuestion q = data.get(index);
        System.out.println("Question " + (index + 1) + ".  " + q.value + " points.");
        if (q.type == TriviaQuestion.TRUEFALSE) {
            System.out.println(q.question);
            System.out.println("Enter 'T' for true or 'F' for false.");
        } else if (q.type == TriviaQuestion.FREEFORM) {
            System.out.println(q.question);
        }
    }

    public int numQuestions() {
        return data.size();
    }

    public TriviaQuestion getQuestion(int index) {
        return data.get(index);
    }
}