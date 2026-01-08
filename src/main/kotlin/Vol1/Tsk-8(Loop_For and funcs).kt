package Vol1

fun main() {
    println("\t Калькулятор пересчета длины из дюймов в миллиметры и наоборот.\n Из какого формата будем переводить?(sm или inch)")
    val userFormat = readln()
    if (userFormat == "cm") {
        println("Введите длинну в сантиметрах:")
        val userLength = readln().toDouble()
        val totalLength = smToInch(userLength)
        print(" - $totalLength в дюймах.")
    }
    else if (userFormat == "inch") {
        println("Введите длинну в дюймах:")
        val userLength = readln().toDouble()
        val totalLength = inchToCm(userLength)
        print(" - $totalLength в сантиметрах.")
    } else {
        println("Вы ввели неверную единицу измерения!")
    }
}

fun inchToCm(length: Double): Double {
    val a = length * 2.54
    return a
}

fun smToInch(length: Double): Double {
    val a = length / 2.54
    return a
}