package Vol1

fun main() {
    val listOfCrops = listOf("Картофель", "Томат", "Огурец", "Перец", "Баклажан")
    val listOfHealthPlants = listOf(0, 0, 0, 1, 0)

    for ((index, crop) in listOfCrops.withIndex()) {
        if (listOfHealthPlants[index] != 0) {
            println("На растении $crop найден вредитель!")
            break
        }
        println("$crop чист! Вредителей не обнаружено!")
        Thread.sleep(1000)
    }
}

