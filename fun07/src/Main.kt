fun main() {
    println("=== ПРОСТОЕ КОДИРОВАНИЕ СЛОВ ===")

    print("Введите слова через пробел: ")
    val input = readLine() ?: ""

    val words = input.split(" ").filter { it.isNotBlank() }

    if (words.isEmpty()) {
        println("Слова не введены!")
        return
    }

    println("\nРезультаты кодирования:")
    words.forEach { word ->
        val pattern = encodeWordSimple(word)
        println("$word -> $pattern")
    }
}

fun encodeWordSimple(word: String): String {
    val map = mutableMapOf<Char, Char>()
    var digit = '0'
    val result = StringBuilder()

    for (char in word) {
        if (char !in map) {
            map[char] = digit
            digit++
        }
        result.append(map[char])
    }

    return result.toString()
}