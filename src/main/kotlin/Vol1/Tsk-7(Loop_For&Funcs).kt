package Vol1

fun main() {
//    var temperature: Double
    println("\tТаблица конверсии температуры из Фаренгейта в Цельсия:\n\tФаренгейт \t|\tЦельсия")
    for (temperature in 100..200 step 5) {
        val b = temperatureConversation(temperature.toDouble())
        println("\t\t$temperature\t\t|\t${String.format("%1.3f", b)}")
    }
}

fun temperatureConversation(temp: Double): Double {
    val a = temp
    return ((a - 32) * 5) / 9

}
