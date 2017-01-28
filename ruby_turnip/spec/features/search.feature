# encoding: utf-8
# language: ja

機能: googleアクセス

  シナリオ: googleを検索
    前提 yahooにアクセス
    もし "google" を検索
    ならば リンク "https://www.google.co.jp/" がある

  シナリオ: githubを検索
    前提 yahooにアクセス
    もし "github" を検索
    ならば リンク "https://github.com/" がある
