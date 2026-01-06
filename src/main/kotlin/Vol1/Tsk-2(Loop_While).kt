package Vol1

const val ONE_WATERING = 15
const val SOIL_MOISTURE_MAX = 100
fun main() {
    var soilMoistureNow = 30
    while (soilMoistureNow < SOIL_MOISTURE_MAX) {

        soilMoistureNow += ONE_WATERING
        println("Добавили $ONE_WATERING. Теперь влажность почвы равна $soilMoistureNow")
        Thread.sleep(3000)
        if (soilMoistureNow + ONE_WATERING > SOIL_MOISTURE_MAX) {
            val extraWatering = SOIL_MOISTURE_MAX - soilMoistureNow
            println("Добавляем $extraWatering!")
            soilMoistureNow += extraWatering
        }
    }
    println("Теперь полито! Влажность почвы на данный момент $soilMoistureNow")
}