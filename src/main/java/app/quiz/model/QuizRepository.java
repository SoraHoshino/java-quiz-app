package app.quiz.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class QuizRepository {

    private static final String API_URL =
            "https://script.googleusercontent.com/macros/echo?user_content_key="
            + "AUkAhnQdq5c5lGyhqkQteGjilxzoCsA26aQ7AoyAvYj1va6CInAX9YW-_mrz_a_3"
            + "aM91byTNCpBdTDYyVJ-J0cjUtXQfbi7xVf366nwtnqXlpLVJIf1dLSF7EG0KS4IjH"
            + "G1EBSK8sVmjFbsc7sJifp84tuguhxwlq7-VsRGDUvmezpIv91tB78y8UbBAYsAKk"
            + "TMNzLfB1T_yKtNpb-43Et2p9bzP8bwF8D3o-8U-3Hf3kRrcY8Gi2wdHmhMt5Wu"
            + "qGT6OwEcGmE-KA3bqzfN4NY_O68LVAwcZOw"
            + "&lib=MZNZgYpjcB1BIne1bWlFDl5e5J8QAxtqO";

    /**
     * クイズデータを別スレッドで読み込む
     */
    public void loadQuizzesAsync(final OnQuizLoadListener listener) {

        Runnable runCommunication = new Runnable() {

            @Override
            public void run() {

                try {
                    // HTTPS通信用のクライアントを作成
                    HttpClient client = HttpClient.newBuilder()
                            .followRedirects(HttpClient.Redirect.ALWAYS)
                            .build();

                    // GETリクエストを作成
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(API_URL))
                            .GET()
                            .build();

                    // 通信を実行してJSONを取得
                    HttpResponse<String> response = client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString());

                    String json = response.body();

                    // JSONをList<Quiz>に変換
                    Gson gson = new Gson();

                    java.lang.reflect.Type listType =
                            new TypeToken<ArrayList<Quiz>>() {
                            }.getType();

                    List<Quiz> quizzes = gson.fromJson(json, listType);

                    // 成功をMain側へ通知
                    if (listener != null) {
                        listener.onSuccess(quizzes);
                    }

                } catch (Exception e) {

                    // 失敗をMain側へ通知
                    if (listener != null) {
                        listener.onFailure(e);
                    }
                }
            }
        };

        // 別スレッドで通信開始
        Thread thread = new Thread(runCommunication);
        thread.start();
    }
}