package app.quiz.util;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.quiz.model.QuizResult;

public class ResultFileWriter {

    private static final Path OUTPUT_PATH =
            Path.of("result.json");

    /**
     * クイズ結果をJSONファイルへ保存します。
     *
     * @param result 保存するクイズ結果
     */
    public void save(QuizResult result) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (Writer writer =
                Files.newBufferedWriter(
                        OUTPUT_PATH,
                        StandardCharsets.UTF_8)) {

            gson.toJson(result, writer);

            AppLogger.print("");
            AppLogger.print(
                    "結果を result.json に保存しました。");

        } catch (IOException e) {

            AppLogger.print(
                    "結果の保存に失敗しました。");

            AppLogger.error(e);
        }
    }
}