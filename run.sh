# 1. テストを実行
mvn test

# 2. コンパイルと実行を Maven に任せる（クラス名を設定するだけ）
# ※ Main がパッケージに属している場合は com.example.Main のように書きます
mvn exec:java -Dexec.mainClass="Main"
