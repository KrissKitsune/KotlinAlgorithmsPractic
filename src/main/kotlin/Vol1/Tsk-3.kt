package Vol1

fun main() {
    val plantsGrow = listOf(5, 7, 9, 12, 15, 19, 23)
    var growWeek = 0
    var previousDay = 0
    var plantsGrows: Int

    for ((index, currentDay) in plantsGrow.withIndex()) {
        plantsGrows = currentDay - previousDay
        if ((plantsGrows >= 4) && (index != 0)) {
            println("В день ${index + 1} растение выросло на $plantsGrows см!")
        }
        growWeek += currentDay
        previousDay = currentDay
    }
    println("Всего за неделю растение выросло на $growWeek!")

}
