package Vol2

const val ASCII_A_CODE = 65

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
            println("Ничья! Больше нет клеток для хода!")
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
    val moveColumn = movePlayer.uppercase().first()
    val row = moveColumn.code - ASCII_A_CODE
    val col = moveString.toInt() - 1
    board[row][col] = currentPlayer
}

fun isValidMove(movePlayer: String, board: Array<Array<Char>>): Boolean {
    val moveString = movePlayer.substring(1)
    val moveColumn = movePlayer.uppercase().first()
    val row = moveColumn.code - ASCII_A_CODE
    val col = moveString.toInt() - 1
    if (board[row][col] != '_') return false
    if (!((moveColumn == 'A') || (moveColumn == 'B') || (moveColumn == 'C')) ||
        !((moveString == "1") || (moveString == "2") || (moveString == "3"))
    ) return false
    return true
}

fun chekWin(currentPlayer: Char, board: Array<Array<Char>>): Boolean {
    for (i in board.indices) {
        if (
            board[i][0] == currentPlayer
            && board[i][1] == currentPlayer
            && board[i][2] == currentPlayer
        ) return true
        if (
            board[0][i] == currentPlayer
            && board[1][i] == currentPlayer
            && board[2][i] == currentPlayer
        ) return true
    }
    if ((board[1][1] == currentPlayer) &&
        ((board[0][0] == currentPlayer) && (board[2][2] == currentPlayer)
                || (board[2][0] == currentPlayer) && (board[0][2] == currentPlayer))
    ) return true
    return false
}

fun chekDraw(board: Array<Array<Char>>): Boolean {
    var k = 0
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] != '_') k++
        }
        if (k == 9) return true
    }
    return false
}