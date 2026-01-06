package Vol1

const val MIN_TEMPERATURE_IN_GREENHOUSE = 10
const val MAX_TEMPERATURE_IN_GREENHOUSE = 35

fun main() {
    val listOfTemperatureInGreenhouse = mutableListOf<Int>()
    var successMeasuredCount = 0

    do {
        println("Введите температуру в теплице:")
        val currentTemperatureInGreenhouse = readln().toInt()
        successMeasuredCount += 1
        listOfTemperatureInGreenhouse.add(currentTemperatureInGreenhouse)
    } while ((currentTemperatureInGreenhouse >= MIN_TEMPERATURE_IN_GREENHOUSE)
        && (currentTemperatureInGreenhouse <= MAX_TEMPERATURE_IN_GREENHOUSE))

    println("Успешных попыток ${successMeasuredCount - 1}")

}