class NextPositionCalculator(){

    fun calculateNextPosition(dice:Int,presentValue:Int,ladders:HashMap<Int,Int>,snakes:HashMap<Int,Int>): Int {
        var newValue:Int=presentValue+dice
        if(dice<0 || dice>6 ){

            return -1
        }
        else if(newValue>100){
            return  presentValue
        }

        if(ladders.containsKey(newValue)) newValue=ladders[newValue]!!
        if(snakes.containsKey(newValue)) newValue=snakes[newValue]!!
        return newValue
    }
}