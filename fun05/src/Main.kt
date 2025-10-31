fun main() {
    println("=== ПРОСТОЙ ПОИСК ПАЛИНДРОМНЫХ ПАР ===")

    print("Введите слова через пробел: ")
    val input = readLine() ?: ""

    val words = input.split(" ").filter { it.isNotBlank() }.map { it.lowercase() }

    if (words.isEmpty()) {
        println("Слова не введены!")
        return
    }

    println("\nПоиск палиндромных пар...")

    val pairs = mutableListOf<Pair<String, String>>()

    for (i in words.indices) {
        for (j in words.indices) {
            if (i != j) {
                val combined = words[i] + words[j]
                if (combined == combined.reversed()) {
                    pairs.add(Pair(words[i], words[j]))
                }
            }
        }
    }

    if (pairs.isEmpty()) {
        println("Палиндромные пары не найдены")
    } else {
        println("Найдено пар: ${pairs.size}")
        pairs.forEach { (word1, word2) ->
            println("\"$word1\" + \"$word2\" = \"${word1 + word2}\"")
        }
    }
}