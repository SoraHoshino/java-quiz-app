package app.quiz.model;

/**
 * スプレッドシートから読み込んだ
 * クイズデータを保存するクラス
 */
public class Quiz {

    /** 問題文 */
    private String question;

    /** 選択肢1～4 */
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;

    /** 正解番号 */
    private int answer;

    /**
     * GsonがJSONを変換するときに使用する
     */
    public Quiz() {
    }

    /**
     * クイズデータを作成するコンストラクタ
     */
    public Quiz(
            String question,
            String choice1,
            String choice2,
            String choice3,
            String choice4,
            int answer) {

        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public int getAnswer() {
        return answer;
    }
}