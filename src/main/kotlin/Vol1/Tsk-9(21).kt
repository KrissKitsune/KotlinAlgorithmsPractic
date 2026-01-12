package Vol1


const val WIN_SUM = 21

fun main() {
    println("""Сыграем в "21"? ;)(true/false)""")
    val startGame = readln().toBoolean()
    if (!startGame) {
        println("Возвращайся, когда наберешься смелости! ;))")
        return
    }
    val userCard = getRandomCard()
    println("Что-ж начнем! Твоя первая карта ${userCard[1]}")
    var sum = userCard[0].toInt()
    var takeCard: Boolean

    do {
        println("Еще карту?(true/false)")
        takeCard = readln().toBoolean()
        if (takeCard) {
            val userCard = getRandomCard()
            println("Следующая карта ${userCard[1]}")
            sum += userCard[0].toInt()
            if (sum >= WIN_SUM) {
                if (sum == WIN_SUM) {
                    println("Вы выйграли! Очко! Сумма карт составила $sum!")
                } else {
                    println("Вы проиграли :( Сумма превысила 21! Сумма карт $sum")
                }
                break
            }
        }
    } while (takeCard)
    if (sum < WIN_SUM) println("Сумма очков составила $sum!")
}


fun getRandomCard(): List<String> {
    var card: Int
    do {
        val cart = (2..11).random()
        card = cart
    } while (cart == 5)
    val name = mutableListOf<String>()
    val a = card.toString()
    name.add(a)
    when (card) {
        2 -> name.add("Валет")
        3 -> name.add("Дама")
        4 -> name.add("Король")
        6 -> name.add("Шестерка")
        7 -> name.add("Семерка")
        8 -> name.add("Восмерка")
        9 -> name.add("Девятка")
        10 -> name.add("Десятка")
        11 -> name.add("Туз")
    }
    return name
}

