package app.quiz.util;

public class AppLogger {

    // falseにすると、すべてのログ出力を停止します
    private static final boolean IS_DEBUG = true;

    /**
     * 改行ありで文字を表示します
     */
    public static void print(String message) {
        if (IS_DEBUG) {
            System.out.println(message);
        }
    }

    /**
     * 改行なしで文字を表示します
     */
    public static void printSameLine(String message) {
        if (IS_DEBUG) {
            System.out.print(message);
        }
    }

    /**
     * エラー内容を表示します
     */
    public static void error(Throwable throwable) {
        if (IS_DEBUG) {
            throwable.printStackTrace();
        }
    }
}