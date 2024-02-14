
fun main(args: Array<String>) {
    val ladders:ArrayList<String> = arrayListOf()
    val snakes:ArrayList<String> = arrayListOf()
    println("Enter the Number of ladders")
    val numOfLadders = readln().toInt()
    println("Enter the head and tail of the ladder")
    for (i in 1..numOfLadders){
        var input= readln()
        ladders.add(input)
    }
    println("Enter the number of snakes")
    val numOfSnakes:Int=readln().toInt()
    println("Enter the head and tail of the snakes in space separated")
    for (i in 1..numOfSnakes){
        var input= readln()
        snakes.add(input)
    }
    println("Enter the number of Users ")
    val noOfUsers= readln().toInt()
    println("Enter the dice value User 1 in space separated format")
    val rawDiceInput: List<Int> = readLine()?.split(" ")?.map { it.toInt() }?.filter { it in 1..6 } ?: emptyList()
    val valuesofDicesTakenFromInputUser= ArrayList(rawDiceInput)
    println(valuesofDicesTakenFromInputUser)
    val game=SnakeAndLadderGame()
    game.generateGameBoard(ladders,snakes,noOfUsers)
    game.HandleNPlayers(valuesofDicesTakenFromInputUser)
}