package Vol1

fun main() {
    val nameOfCrops = mutableListOf<String>()
    val weightOfCrops = mutableListOf<Int>()
    var totalWeight = 0

    println("Напишите итоговое количество культур для подсчета:")
    val sumOfCrops = readln().toInt()

    for (i in 1..sumOfCrops) {
        println("Введите название культуры $i для подсчета:")
        val a = readln()
        nameOfCrops.add(a)
        println("Введите сколько урожая этой культуры собрано:")
        val b = readln().toInt()
        weightOfCrops.add(b)
        totalWeight += b
    }
    println("Итоговое колличество урожая: $totalWeight, а средний урожай на культуру: ${totalWeight / sumOfCrops}\n  \tИтоговая таблица культур:")

    for (i in 1..sumOfCrops) {
        println("${nameOfCrops[i - 1]} - ${weightOfCrops[i - 1]}")
    }
}