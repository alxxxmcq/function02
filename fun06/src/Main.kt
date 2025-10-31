fun main() {
    println("=== ПРОСТОЙ АНАЛИЗ ЦЕПОЧЕК СЛОВ ===")

    print("Введите слова через пробел: ")
    val input = readLine() ?: ""

    val words = input.split(" ").filter { it.isNotBlank() }.map { it.lowercase() }

    if (words.isEmpty()) {
        println("Слова не введены!")
        return
    }

    // Находим все цепочки
    val chains = mutableListOf<List<String>>()

    fun findChains(currentChain: List<String>, used: Set<String>) {
        chains.add(currentChain)

        val lastWord = currentChain.last()
        val lastChar = lastWord.last()

        for (word in words) {
            if (word !in used && word.first() == lastChar) {
                findChains(currentChain + word, used + word)
            }
        }
    }

    // Запускаем из каждого слова
    for (word in words) {
        findChains(listOf(word), setOf(word))
    }

    // Фильтруем цепочки длины 2 и более
    val meaningfulChains = chains.filter { it.size >= 2 }

    println("\nНайдено цепочек: ${meaningfulChains.size}")
    meaningfulChains.forEach { chain ->
        println(chain.joinToString(" → "))
    }

    // Самая длинная цепочка
    val longest = chains.maxByOrNull { it.size } ?: emptyList()
    if (longest.isNotEmpty()) {
        println("\nСамая длинная цепочка (${longest.size} слов):")
        println(longest.joinToString(" → "))
    }
}