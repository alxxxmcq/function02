fun main() {
    println("=== ПРОСТОЙ ПОИСК МАКСИМАЛЬНОГО ПЕРЕСЕЧЕНИЯ ===")

    print("Введите слова через пробел: ")
    val input = readLine() ?: ""

    val words = input.split(" ").filter { it.isNotBlank() }.map { it.lowercase() }

    if (words.size < 2) {
        println("Нужно хотя бы 2 слова!")
        return
    }

    var maxCommon = 0
    var bestPair = Pair("", "")
    var bestLetters = ""

    for (i in words.indices) {
        for (j in i + 1 until words.size) {
            val (commonCount, commonLetters) = findCommonLettersSimple(words[i], words[j])
            if (commonCount > maxCommon) {
                maxCommon = commonCount
                bestPair = Pair(words[i], words[j])
                bestLetters = commonLetters
            }
        }
    }

    println("\nРезультат:")
    println("Лучшая пара: ${bestPair.first} + ${bestPair.second}")
    println("Общих букв: $maxCommon")
    println("Буквы: $bestLetters")
}

fun findCommonLettersSimple(word1: String, word2: String): Pair<Int, String> {
    val freq1 = word1.groupingBy { it }.eachCount()
    val freq2 = word2.groupingBy { it }.eachCount()

    var total = 0
    val letters = mutableListOf<Char>()

    for ((char, count1) in freq1) {
        val count2 = freq2[char] ?: 0
        val common = minOf(count1, count2)
        repeat(common) {
            letters.add(char)
            total++
        }
    }

    return Pair(total, letters.joinToString(""))
}