## プロジェクト構成

```text
java-quiz-app
├── src/main/java
│   └── app/quiz
│       ├── Main.java
│       ├── game
│       │   └── QuizGame.java
│       ├── model
│       │   ├── Quiz.java
│       │   ├── QuizResult.java
│       │   ├── QuizRepository.java
│       │   └── OnQuizLoadListener.java
│       └── util
│           ├── AppLogger.java
│           └── ResultFileWriter.java
├── pom.xml
├── .gitignore
└── README.md
```

## 実行方法

1. Eclipseでプロジェクトを開きます。
2. Mavenの依存関係を更新します。
3. `Main.java` をJavaアプリケーションとして実行します。
4. コンソールに表示される問題に回答します。
5. 全問終了後、`result.json` が作成されます。

## result.jsonの例

```json
{
  "score": 15,
  "totalQuestions": 20,
  "completedAt": "2026-06-23 13:45:20"
}
```

## 作者

SoraHoshino
