package Vol2

fun main() {
    println("Добро пожаловать в Крестики-нолики!")

    val board = arrayOf(
        arrayOf('_', '_', '_'),
        arrayOf('_', '_', '_'),
        arrayOf('_', '_', '_')
    )
    var currentPlayer = 'O'
    var gameOver = false
    var chekDraw: Boolean
    var chekWin: Boolean
    while (!gameOver) {
        if (currentPlayer == 'X') currentPlayer = 'O' else currentPlayer = 'X'
        printBoard(board)
        println("Ход игрока $currentPlayer! Введите позицию(например B2):")
        var movePlayer = readln()
        val validMove = isValidMove(movePlayer, board)
        if (!validMove) {
            do {
                println("Введите корректную позицию!")
                movePlayer = readln()
                val validMove = isValidMove(movePlayer, board)
            } while (!validMove)
        }
        makeMove(movePlayer, currentPlayer, board)
        chekWin = chekWin(currentPlayer, board)
        chekDraw = chekDraw(board)
        if (chekWin) {
            printBoard(board)
            println("Победа за игроком: $currentPlayer")
            gameOver = true
        } else if (chekDraw) {
            println("Ничья!")
            gameOver = true
        } else continue
    }
}

fun printBoard(board: Array<Array<Char>>) {
    var columnChar = 'A'
    println("\t\t1\t   2\t  3")
    for (i in board.indices) {
        print("\t$columnChar")
        columnChar++
        for (j in board[i].indices) {
            print(" | " + "${board[i][j]} " + "| ")
        }
        println()
    }
}

fun makeMove(movePlayer: String, currentPlayer: Char, board: Array<Array<Char>>) {
    val moveString = movePlayer.substring(1)
    val moveColumn = movePlayer.first()
    if (moveColumn == 'A') {
        if (moveString == "1") {
            board[0][0] = currentPlayer
        } else if (moveString == "2") {
            board[0][1] = currentPlayer
        } else board[0][2] = currentPlayer
    } else if (moveColumn == 'B') {
        if (moveString == "1") {
            board[1][0] = currentPlayer
        } else if (moveString == "2") {
            board[1][1] = currentPlayer
        } else board[1][2] = currentPlayer
    } else {
        if (moveString == "1") {
            board[2][0] = currentPlayer
        } else if (moveString == "2") {
            board[2][1] = currentPlayer
        } else board[2][2] = currentPlayer
    }
}

fun isValidMove(movePlayer: String, board: Array<Array<Char>>): Boolean {

    val moveString = movePlayer.substring(1)
    val moveColumn = movePlayer.first().toString()
    val validMove: Boolean
    var k: Int
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == '_') k = 0 else k = 1
        }
    }
    k = if (((moveColumn == "A") || (moveColumn == "B") || (moveColumn == "C")) &&
        ((moveString == "1") || (moveString == "2") || (moveString == "3"))
    ) 0 else 1
    if (k < 1) {
        validMove = true
    } else validMove = false
    return validMove
}

fun chekWin(currentPlayer: Char, board: Array<Array<Char>>): Boolean {
    var sumChek = 0
    var crossChek: Boolean
    var chekWin = false
    for (i in board.indices) {
        if (board[i][i] == currentPlayer) {
            for (j in board.indices) {
                if (board[i][j] == currentPlayer) {
                    sumChek++
                    //println("сумма очков $sumChek")
                }
            }
        }
    }
    if ((board[1][1] == currentPlayer) &&
        ((board[0][0] == currentPlayer) || (board[2][2] == currentPlayer)
                || (board[2][0] == currentPlayer) || (board[0][2] == currentPlayer))
    ) crossChek = true
    else crossChek = false
    if ((sumChek >= 3) || (crossChek)) chekWin = true
    return chekWin
}

fun chekDraw(board: Array<Array<Char>>): Boolean {
    var k = 0
    var chekDraw = false
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] != '_') k++
        }
        if (k == 9) chekDraw = true
    }
    return chekDraw
}