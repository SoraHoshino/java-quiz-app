package app.quiz;

import java.util.List;

import app.quiz.model.OnQuizLoadListener;
import app.quiz.model.Quiz;
import app.quiz.model.QuizRepository;
import app.quiz.util.AppLogger;

public class Main {

    public static void main(String[] args) {

        AppLogger.print("クイズデータの読み込みを開始します...");

        QuizRepository repository = new QuizRepository();

        repository.loadQuizzesAsync(new OnQuizLoadListener() {

            @Override
            public void onSuccess(List<Quiz> quizzes) {

                AppLogger.print(
                        "通信成功！届いた問題数: "
                        + quizzes.size()
                        + "問");

                // 1問目が存在する場合だけ表示
                if (!quizzes.isEmpty()) {

                    Quiz firstQuiz = quizzes.get(0);

                    AppLogger.print(
                            "第1問: "
                            + firstQuiz.getQuestion());

                    AppLogger.print(
                            "選択肢1: "
                            + firstQuiz.getChoice1());

                    AppLogger.print(
                            "選択肢2: "
                            + firstQuiz.getChoice2());

                    AppLogger.print(
                            "選択肢3: "
                            + firstQuiz.getChoice3());

                    AppLogger.print(
                            "選択肢4: "
                            + firstQuiz.getChoice4());
                }
            }

            @Override
            public void onFailure(Exception e) {

                AppLogger.print("通信失敗...");
                AppLogger.error(e);
            }
        });

        AppLogger.print(
                "Mainメソッドの処理はここで終わりです。"
                + "通信はバックグラウンドで続いています。");
    }
}