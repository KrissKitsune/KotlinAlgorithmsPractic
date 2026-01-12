package Vol1

const val DAYS_FERTILIZES_FOR_PLANTS = 6

fun main() {
    val daysPerSeason = 90
    val interspaceBetweenTreatment = daysPerSeason / DAYS_FERTILIZES_FOR_PLANTS
    println("Интервал между обработками составляет - $interspaceBetweenTreatment")

    for (i in 1..daysPerSeason step interspaceBetweenTreatment) {
        println("Обработка требуется на $i день!")
    }
}
