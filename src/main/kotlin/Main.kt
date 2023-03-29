fun main() {
    println("Enter the number of rows:")
    println("> ")
    val rows = readln().toInt()
    println("Enter the number of seats in each row")
    println("> ")
    val seats = readln().toInt()
    // Create Array2D
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    for (i in 0 until rows) {
        val stringsList = MutableList(seats) { "S" }
        inputList.add(stringsList)
    }
    /***********************************************************************************/

    var purchasedTickets = 0
    var percentage = 0.0
    var currentIncome = 0
    /***********************************************************************************/

    fun statistics() {

        println("Number of purchased tickets: $purchasedTickets")
        println("Percentage: ${"%.2f".format(percentage)}%")
        println("Current income: $$currentIncome")
        println("Total income: $${if ((rows * seats) <= 60){
            10 * rows * seats
        } else {
            (10 * (rows / 2) * seats) + (8 * ((rows - (rows / 2)) * seats))
        }}")
        println()
    }
    /***********************************************************************************/

    fun printArray() {
        println("Cinema:")
        print("  ")
        for (i in 1..seats) print("${i} ")
        println()
        for (i in 0 until rows) {
            println("${i + 1} ${inputList[i].joinToString(" ")}")
        }
        println()
    }
    /***********************************************************************************/
    fun showSelection () {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        println("> ")
    }
    /***********************************************************************************/
    fun buyTicket () {
        println("Enter a row number:")
        println("> ")
        val row = readln().toInt()
        println("Enter a seat number in that row:")
        println("> ")
        val col = readln().toInt()
        val ticketPrice: Int = if ((rows * seats) <= 60 || row <= rows / 2) {
            10
        } else {
            8
        }
        try {
            if (inputList[row - 1][col - 1] == "B") {
                println()
                println("That ticket has already been purchased!")
                println()
                buyTicket()
            } else {
                println("Ticket price: $$ticketPrice")
                println()
                inputList[row - 1][col - 1] = "B"
                purchasedTickets += 1
                percentage = (purchasedTickets.toDouble() * 100) / (rows * seats)
                currentIncome += ticketPrice
            }
        } catch (e: IndexOutOfBoundsException) {
            println()
            println("Wrong input!")
            println()
            buyTicket()
        }
    }


    /***********************************************************************************/

    /***********************************************************************************/

    showSelection()
    do {
        val number = readln()

        when (number) {
            "1" -> {
                printArray()
                showSelection()
            }
            "2" -> {
                buyTicket()
                showSelection()
            }
            "3" -> {
                statistics()
                showSelection()
            }
        }
    } while (number != "0")
    /***********************************************************************************/
}