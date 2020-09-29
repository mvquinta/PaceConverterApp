//Logical code for finding pace app

fun main(args: Array<String>) {
    /*var kmDist: Double = 13.0
   var kmDist = 15.23
   var timeHr: Int = 1
   var timMin: Int = 5
   var timeScnd: Int = 23*/

    fun findPace(kmDist: Double, timeHr: Int, timMin: Int, timeScnd:Int) {
        val totalTimMin: Double = (timeHr * 60.0).toDouble() + timMin.toDouble() + (timeScnd/60.0).toDouble()

        //calculates pace. But this result must be converted to time format, that's why it's a temp variable
        val tempPace: Double = totalTimMin / kmDist.toDouble()

        //I find and separate the decimal part of my pace. I must convert the decimal part into seconds
        val restTempPace =  ((tempPace - (tempPace.toInt().toDouble())))

        //here I convert decimal part into seconds and than turn it into a String to be able to print it
        //I convert tempPace to int to "clean" my decimal part. I than convert it again to double to be able to add the restTempPace converted to seconds
        //finally I convert the result into string to final print
        val finalPace = (tempPace.toInt().toDouble() + (restTempPace*0.6)).toString()

        //since I was having difficulty in printing my result because decimals were being round up. I went for a string solution. Not so elegant....
        println("Your pace was: ${finalPace[0]}${finalPace[1]}${finalPace[2]}${finalPace[3]} min/km")
    }

    fun findSpeed(kmDist: Double, timeHr: Int, timMin: Int, timeScnd:Int) {
        val minToHr = timMin.toDouble() / 60
        val scndToHr = timeScnd.toDouble() / 3600
        val totalHr = timeHr.toDouble() + minToHr + scndToHr
        val speed = kmDist / totalHr
        println("Your speed was: " + "%.2f".format(speed) + " km/h")
    }

    findPace(13.0, 1, 5, 23)
    findSpeed(13.0, 1, 5, 23)

    //convert time to minutes
    /*val totalTimMin: Double = (timeHr * 60.0).toDouble() + timMin.toDouble() + (timeScnd/60.0).toDouble()

    //calculates pace. But this result must be converted to time format, that's why it's a temp variable
    val tempPace: Double = totalTimMin / kmDist.toDouble()

    //I find and separate the decimal part of my pace. I must convert the decimal part into seconds
    val restTempPace =  ((tempPace - (tempPace.toInt().toDouble())))

    //here I convert decimal part into seconds and than turn it into a String to be able to print it
    //I convert tempPace to int to "clean" my decimal part. I than convert it again to double to be able to add the restTempPace converted to seconds
    //finally I convert the result into string to final print
    val finalPace = (tempPace.toInt().toDouble() + (restTempPace*0.6)).toString()

    //since I was having difficulty in printing my result because decimals were being round up. I went for a string solution. Not so elegant....
    println("Your pace was: ${finalPace[0]}${finalPace[1]}${finalPace[2]}${finalPace[3]} min/km")

    //lets find speed now. For speed I need total distance divided by time (km/hours)
    val minToHr = timMin.toDouble() / 60
    val scndToHr = timeScnd.toDouble() / 3600
    val totalHr = timeHr.toDouble() + minToHr + scndToHr
    val speed = kmDist / totalHr
    println("Your speed was: " + "%.2f".format(speed) + " km/h")*/
}
//Important Note: In the app, better solution is to ask for user to input string and than convert it to double?
//Or force user to input a double? If so, how? I can let kotlin infer the value input and than, in my function, convert input into double