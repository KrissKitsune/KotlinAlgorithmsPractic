package org.example.Vol1

fun main() {
    println("Введите набор слов через пробел:")
    val someWords = readln().lowercase().split(" ", ",", ".", "-", ":")
    val chartOfWorlds = mutableMapOf<String, Int>()

    someWords.forEach {
        if (chartOfWorlds.containsKey(it)) {
            var k = chartOfWorlds.getOrDefault(it, 1)
            k++
            chartOfWorlds[it] = k
        } else chartOfWorlds[it] = 1
    }

    val comparator = compareByDescending<Pair<String, Int>> { it.second }
        .thenBy { it.first }

    val sorted = chartOfWorlds.toList().sortedWith(comparator)

    println(sorted)
}


