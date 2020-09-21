package ch.heigvd.amt.stackovergoat.services;

import ch.heigvd.amt.stackovergoat.model.Question;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class QuestionManager {
    public LinkedList<Question> getQuestions() {
        LinkedList<Question> questions = new LinkedList<Question>();
        questions.add(new Question("Hello", 1));
        return questions;
        //return questionsFromJSON(new JsonManager().getJsonContent("src/main/resources/questions.json"));
    }

    public LinkedList<Question> questionsFromJSON(String jsonFile) {
        LinkedList<Question> questions = new LinkedList<>();

        try {
            JSONArray jsonArray = new JSONArray(new JSONObject(jsonFile).getJSONArray("questions"));

            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsonQuestion = jsonArray.getJSONObject(i);
                questions.add(new Question(jsonQuestion.getString("title"), jsonQuestion.getInt("id")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
