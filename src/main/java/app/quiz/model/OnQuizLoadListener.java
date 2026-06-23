package app.quiz.model;

import java.util.List;

/**
 * クイズデータの読み込み結果を受け取る
 * コールバックインターフェース
 */
public interface OnQuizLoadListener {

    /**
     * 通信成功時に呼び出される
     *
     * @param quizzes 読み込んだクイズ一覧
     */
    void onSuccess(List<Quiz> quizzes);

    /**
     * 通信失敗時に呼び出される
     *
     * @param e 発生したエラー
     */
    void onFailure(Exception e);
}