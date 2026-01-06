package Vol1

fun main() {
    val listOfTemperatureInGreenhouse = mutableListOf<Int>()
    var successMeasuredCount = 0

    do {
        println("Введите температуру в теплице:")
        val currentTemperatureInGreenhouse = readln().toInt()
        successMeasuredCount += 1
        listOfTemperatureInGreenhouse.add(currentTemperatureInGreenhouse)
    } while ((currentTemperatureInGreenhouse >= 10) && (currentTemperatureInGreenhouse <= 36))

    println("Успешных попыток ${successMeasuredCount - 1}")

}