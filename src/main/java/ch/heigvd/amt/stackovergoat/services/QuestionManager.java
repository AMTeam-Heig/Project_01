package ch.heigvd.amt.stackovergoat.services;

import ch.heigvd.amt.stackovergoat.model.Question;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class QuestionManager {
    public LinkedList<Question> getQuestions() {
        // TODO : get all questions in database or .json file
        JsonManager jsonManager = new JsonManager();
        return questionsFromJSON(jsonManager.getJsonContent("/resources/questions.json"));
    }

    public LinkedList<Question> questionsFromJSON(String jsonFile) {
        LinkedList<Question> questions = new LinkedList<>();

        try {
            JSONArray jsonArray = new JSONArray(new JSONObject(jsonFile).getJSONArray("questions"));

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonQuestion = jsonArray.getJSONObject(i);
                questions.add(new Question(jsonQuestion.getString("title"), jsonQuestion.getInt("id")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
