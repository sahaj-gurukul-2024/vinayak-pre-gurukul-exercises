fun gamePlayLogicE(presentValue:Int,dice:Int,ladders:HashMap<Int,Int>,snakes:HashMap<Int,Int>): Int {
    var newValue:Int=presentValue+dice
    if(newValue>100){
        return  presentValue
    }
    if(ladders.containsKey(newValue)) newValue=ladders[newValue]!!
    if(snakes.containsKey(newValue)) newValue=snakes[newValue]!!
    return newValue
}
fun main(args: Array<String>) {
    //declaring the snake and ladder
    //used hashmap for the optimsied time complexity
    var ladders: HashMap<Int,Int> = HashMap<Int,Int> ()
    var snakes: HashMap<Int,Int> =  HashMap<Int,Int> ()

    println("Enter the Number of ladders")
    var numOfLadders:Int= readln().toInt()

    println("Enter the input for ladder line by line in space separated manner")
    for (i in 1..numOfLadders){
        var (foot,head)= readln().split(" ").map{it.toInt()}
        ladders.put(foot,head)
    }
    print("Enter the number of snakes")
    var numOfSnakes:Int=readln().toInt()
    println("Enter the input for snakes line by line in space separated manner")
    for (i in 1..numOfSnakes){
        var (foot,head)= readln().split(" ").map{it.toInt()}
        ladders.put(foot,head)
    }
    println("Enter the dice value in space separated format")
    val diceValues: List<Int> = readLine()?.split(" ")?.map { it.toInt() }?.filter { it in 1..6 } ?: emptyList()
    println("Valid dice values: $diceValues")
    var presentValue=1
    for(dice in diceValues){
        presentValue=gamePlayLogicE(presentValue,dice,ladders,snakes)
        if(presentValue==100){
            println("Winner")
        }
    }

    println("final position is $presentValue")
}