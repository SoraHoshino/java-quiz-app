package app.quiz.model;

/**
 * クイズの実行結果を保存するクラス
 */
public class QuizResult {

    private final int score;
    private final int totalQuestions;
    private final String completedAt;

    public QuizResult(
            int score,
            int totalQuestions,
            String completedAt) {

        this.score = score;
        this.totalQuestions = totalQuestions;
        this.completedAt = completedAt;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public String getCompletedAt() {
        return completedAt;
    }
}