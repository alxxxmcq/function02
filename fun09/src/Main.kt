fun main() {
    println("=== ПРОСТОЕ РАЗБИЕНИЕ НА СЛОГИ ===")

    print("Введите слова через пробел: ")
    val input = readLine() ?: ""

    val words = input.split(" ").filter { it.isNotBlank() }.map { it.lowercase() }

    if (words.isEmpty()) {
        println("Слова не введены!")
        return
    }

    println("\nРезультаты разбиения:")
    words.forEach { word ->
        val syllables = splitIntoSyllablesSimple(word)
        println("$word -> ${syllables.joinToString("-")} (${syllables.size} сл.)")
    }
}

fun splitIntoSyllablesSimple(word: String): List<String> {
    val vowels = setOf('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я')
    val syllables = mutableListOf<String>()
    var current = StringBuilder()

    for (char in word) {
        current.append(char)
        if (char in vowels) {
            syllables.add(current.toString())
            current.clear()
        }
    }

    // Если остались согласные в конце
    if (current.isNotEmpty()) {
        if (syllables.isNotEmpty()) {
            val last = syllables.removeAt(syllables.size - 1)
            syllables.add(last + current.toString())
        } else {
            syllables.add(current.toString())
        }
    }

    return syllables
}