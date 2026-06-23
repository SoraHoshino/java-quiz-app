# Java Quiz App

Googleスプレッドシートからクイズデータを取得し、
Javaのコンソール上で問題に回答できるクイズアプリです。

## プロジェクト概要

このプロジェクトは、Javaを使用した実践的なシステム開発の学習を目的として作成しました。

Googleスプレッドシートで管理されたクイズデータをHTTPS通信で取得し、
Javaプログラム上で問題を表示・回答します。

## 使用技術

- Java 17
- Maven
- Gson 2.10.1
- Google Spreadsheet
- HTTPS通信
- JSON
- Git / GitHub
- Eclipse

## 主な機能

- Googleスプレッドシートからクイズデータを取得
- 問題と4つの選択肢を表示
- ユーザーの回答を判定
- 得点を計算
- 実行結果をJSON形式で保存

## プロジェクト構成

```text
java-quiz-app
├── src/main/java
│   └── app/quiz
│       ├── Main.java
│       ├── model
│       │   ├── Quiz.java
│       │   ├── QuizRepository.java
│       │   └── OnQuizLoadListener.java
│       └── util
│           └── AppLogger.java
├── pom.xml
├── .gitignore
└── README.md