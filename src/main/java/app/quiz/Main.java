package app.quiz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import app.quiz.game.QuizGame;
import app.quiz.model.OnQuizLoadListener;
import app.quiz.model.Quiz;
import app.quiz.model.QuizRepository;
import app.quiz.model.QuizResult;
import app.quiz.util.AppLogger;
import app.quiz.util.ResultFileWriter;

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

                if (quizzes == null || quizzes.isEmpty()) {
                    AppLogger.print("問題データがありません。");
                    return;
                }

                // クイズを開始して得点を受け取る
                QuizGame game = new QuizGame();
                int score = game.start(quizzes);

                // 終了日時を作成
                String completedAt = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern(
                                "yyyy-MM-dd HH:mm:ss"));

                // 保存する結果データを作成
                QuizResult result = new QuizResult(
                        score,
                        quizzes.size(),
                        completedAt);

                // result.jsonへ保存
                ResultFileWriter fileWriter =
                        new ResultFileWriter();

                fileWriter.save(result);
            }

            @Override
            public void onFailure(Exception e) {

                AppLogger.print("通信失敗...");
                AppLogger.error(e);
            }
        });

        AppLogger.print(
                "問題データをバックグラウンドで読み込んでいます。");
    }
}