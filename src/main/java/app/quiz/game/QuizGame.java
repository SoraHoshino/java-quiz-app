package app.quiz.game;

import java.util.List;
import java.util.Scanner;

import app.quiz.model.Quiz;
import app.quiz.util.AppLogger;

public class QuizGame {

    /**
     * クイズを開始し、最終得点を返します。
     *
     * @param quizzes クイズ一覧
     * @return 最終得点
     */
    public int start(List<Quiz> quizzes) {

        Scanner scanner = new Scanner(System.in);

        int score = 0;

        for (int i = 0; i < quizzes.size(); i++) {

            Quiz quiz = quizzes.get(i);

            AppLogger.print("");
            AppLogger.print(
                    "========== 第" + (i + 1) + "問 ==========");

            AppLogger.print(quiz.getQuestion());

            AppLogger.print("1. " + quiz.getChoice1());
            AppLogger.print("2. " + quiz.getChoice2());
            AppLogger.print("3. " + quiz.getChoice3());
            AppLogger.print("4. " + quiz.getChoice4());

            int userAnswer = readAnswer(scanner);

            if (userAnswer == quiz.getAnswer()) {

                AppLogger.print("正解！");
                score++;

            } else {

                AppLogger.print("不正解...");
                AppLogger.print(
                        "正解は "
                        + quiz.getAnswer()
                        + " 番です。");
            }

            AppLogger.print(
                    "現在の得点: "
                    + score
                    + " / "
                    + (i + 1));
        }

        AppLogger.print("");
        AppLogger.print("========== クイズ終了 ==========");

        AppLogger.print(
                "最終得点: "
                + score
                + " / "
                + quizzes.size());

        return score;
    }

    /**
     * 1～4が入力されるまで繰り返します。
     */
    private int readAnswer(Scanner scanner) {

        while (true) {

            AppLogger.printSameLine(
                    "回答を入力してください（1～4）: ");

            String input = scanner.nextLine().trim();

            try {

                int answer =
                        Integer.parseInt(input);

                if (answer >= 1 && answer <= 4) {
                    return answer;
                }

            } catch (NumberFormatException e) {
                // 数字以外の場合は再入力
            }

            AppLogger.print(
                    "入力エラー：1～4の数字を入力してください。");
        }
    }
}