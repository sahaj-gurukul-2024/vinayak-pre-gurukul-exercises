class SnakeAndLadderGame(){
    val ladders: HashMap<Int,Int> = HashMap<Int,Int> ()
    val snakes: HashMap<Int,Int> =  HashMap<Int,Int> ()
    var inputInvalid:Boolean=false
    var winner:Boolean=false
    var playerList:ArrayList<String> = arrayListOf()
    var positionList:ArrayList<Int> = arrayListOf()

    fun generateGameBoard(laddersInput: ArrayList<String>,snakesInput:ArrayList<String>,numberOfPlayer:Int){

        var foot:Int
        var head:Int
        for(i in 1..numberOfPlayer){
            var userNameOfThePlayer="Player $i"
            playerList.add(userNameOfThePlayer)
            positionList.add(0)
        }
        for(ladder in laddersInput){
            foot= ladder.split(" ")[0].toInt()
            head=ladder.split(" ")[1].toInt()
            if (foot>head){
                throw Exception("ladder input invalid")
            }
            else{
                ladders[foot] = head
            }

        }
        for(snake in snakesInput){
            foot= snake.split(" ")[0].toInt()
            head=snake.split(" ")[1].toInt()
            if(foot<head){
                throw ArithmeticException("snake input invalid")
            }
            else{
                snakes[foot]=head
            }

        }

    }

    fun HandleNPlayers(diceInputs:ArrayList<Int>):ArrayList<Int>{
        val noOfPlayers=playerList.size
        val diceinputSize:Int=diceInputs.size-1
        var currentPlayer:Int=0
        for (i in 0..diceinputSize){
            val isContinue=playTheGame(diceInputs,currentPlayer,i)
            if(!isContinue){
                break
            }
            currentPlayer=(currentPlayer+1) % noOfPlayers
        }
        return positionList;

    }
    fun playTheGame(diceInputs:ArrayList<Int>, playerCount:Int, indexOfDice:Int):Boolean{


        val findTheNextPosition=NextPositionCalculator()
        val diceValue=diceInputs[indexOfDice]
        val score=positionList[playerCount]
        val returnedValue=findTheNextPosition.calculateNextPosition(diceValue,score,ladders,snakes)
        positionList[playerCount]=returnedValue
        if(returnedValue==100){
            winner=true
            return false
        }
        else{
            return true
        }
    }

}