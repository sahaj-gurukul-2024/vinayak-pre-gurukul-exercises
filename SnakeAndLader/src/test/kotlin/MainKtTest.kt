import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFails

class MainKtTest(){
    //try to use before Each
    @Test
    fun `dice value given by the user should not be greater than six`(){
        //arrange
        val findTheNextPosition=NextPositionCalculator()
        val snakes:HashMap<Int,Int> = hashMapOf()
        val ladders:HashMap<Int,Int> = hashMapOf()
        val recivedValue=findTheNextPosition.calculateNextPosition(7,0,ladders,snakes)
        assertEquals(-1,recivedValue)
    }
    @Test
    fun `dice value is between one and 6`(){
        val findTheNextPosition=NextPositionCalculator()
        val snakes:HashMap<Int,Int> = hashMapOf()
        val ladders:HashMap<Int,Int> = hashMapOf()
        val recivedValue=findTheNextPosition.calculateNextPosition(2,0,ladders,snakes)
        assertNotEquals(-1,recivedValue)
    }
    @Test
    fun  `player will win when he reaches 100 `(){
        //arrange
        val game=SnakeAndLadderGame()
        val snakeList:ArrayList<String> = arrayListOf()
        val laderList:ArrayList<String> = arrayListOf()
        val valueOfDices:ArrayList<Int> = arrayListOf()

        //action
        repeat(100){
            valueOfDices.add(1)
        }
        game.generateGameBoard(laderList,snakeList,1,)
        game.HandleNPlayers(valueOfDices)
        //assertion
        assertEquals(true,game.winner)
    }
    @Test
    fun `player reaches the ladder and climbing the ladder to the top position of it`(){
            val calculateNextMove=NextPositionCalculator()
            val ladders:HashMap<Int,Int> = hashMapOf()
            val snakes:HashMap<Int,Int> = hashMapOf()
            ladders[10]=20
            val currentPosition=calculateNextMove.calculateNextPosition(2,8,ladders,snakes)
            assertEquals(20,currentPosition)

    }
    @Test
    fun `player reaches the Snake Head and reaching the tail of the snake`(){
        val calculateNextMove=NextPositionCalculator()
        val ladders:HashMap<Int,Int> = hashMapOf()
        val snakes:HashMap<Int,Int> = hashMapOf()
        snakes[20]=10
        val currentPosition=calculateNextMove.calculateNextPosition(2,18,ladders,snakes)
        assertEquals(10,currentPosition)

    }
    @Test
    fun `player should start at 1`(){
        //arrange
        val game=SnakeAndLadderGame()
        val diceValue:ArrayList<Int> = arrayListOf()
        val ladders:ArrayList<String> = arrayListOf()
        val snakes:ArrayList<String> = arrayListOf()
        //actiom
        game.generateGameBoard(ladders,snakes,2)
        val returnedValue=game.HandleNPlayers(diceValue)
        //assertion
        for (value in returnedValue){
            assertEquals(0,value)
        }


    }

    @Test
    fun `present value of the player does not goes above 100 and stays below 100 till the sum exaclty becomes 100 if we have more input also`(){
        val game=SnakeAndLadderGame()
        val diceValue:ArrayList<Int> = arrayListOf()
        val ladders:ArrayList<String> = arrayListOf()
        val snakes:ArrayList<String> = arrayListOf()
        repeat(99){
            diceValue.add(1)
        }
        diceValue.add(2)
        //actiom
        game.generateGameBoard(ladders,snakes,1)
        val currentPostion=game.HandleNPlayers(diceValue)
        assertEquals(99,currentPostion[0])
    }
    @Test
    fun `whether the ladder start value is lesser than the ladder top or not `(){
            val game=SnakeAndLadderGame()
            val ladderInput:ArrayList<String> = arrayListOf()
            val snakeInput:ArrayList<String>  = arrayListOf()
            ladderInput.add("20 10")
            val errorRecived = assertFails { game.generateGameBoard(ladderInput,snakeInput,1) }
            assertEquals("ladder input invalid",errorRecived.message)

    }
    @Test
    fun `whether the snake head value is more than the snake tail or not `(){
        val game=SnakeAndLadderGame()
        val ladderInput:ArrayList<String> = arrayListOf()
        val snakeInput:ArrayList<String>  = arrayListOf()
        snakeInput.add("10 20")
        val errorRecived = assertFails { game.generateGameBoard(ladderInput,snakeInput,1) }
        assertEquals("snake input invalid",errorRecived.message)
    }

    @Test
    fun `whether the players are changing the turn or not`(){
        val game=SnakeAndLadderGame()
        val diceValue:ArrayList<Int> = arrayListOf()
        val ladders:ArrayList<String> = arrayListOf()
        val snakes:ArrayList<String> = arrayListOf()
        repeat(4){
            diceValue.add(1)
        }
        diceValue.add(2)
        game.generateGameBoard(ladders,snakes,2)
        val currentPostion=game.HandleNPlayers(diceValue)
        assertEquals(4,currentPostion[0])
        assertEquals(2,currentPostion[1])
    }



}