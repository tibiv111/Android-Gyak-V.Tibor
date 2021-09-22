package fundamentals

import java.util.*

fun main()
{
    println("Hello");
    val daysOfWeek : List<String> = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    for(item in daysOfWeek)
    {
        println(item)
    }

    //aysOfWeek.forEach {day -> println(day)}

    //daysOfWeek.forEach {println(it)}


    //fel1()
    //fel2(daysOfWeek)
    for (i in 2..100)
    {
        val k = fel3(i);
        println( "$i = $k")

    }
    encode("Hi there. How are you?");
    decode("SGkgdGhlcmUuIEhvdyBhcmUgeW91Pw==");

}

fun fel1()
{
    val num1 = 2
    val num2 = 3

    println( "$num1 + $num2 = ${num1+num2}")

}

fun fel2(daysOfWeek:List<String>)
{
    daysOfWeek.filter{it.startsWith('T')}.forEach{println(it)}
    daysOfWeek.filter{it.contains('e')}.forEach{println(it)}
    daysOfWeek.filter { it.length == 6  }.forEach{println(it)}
}

fun fel3(n : Int) : Boolean
{
    var i = 2
    var p = 1
    while (i < n) {
        if (n % i == 0) {
            p = 0
            break
        }
        i++
    }

    return p == 1
}

fun encode(oriString:String)
{
    val encodedString: String = Base64.getEncoder().encodeToString(oriString.toByteArray())
    println(encodedString)

}

fun decode(encodedString:String)
{
    val decodedBytes = Base64.getDecoder().decode(encodedString)
    val decodedString = String(decodedBytes)
    println(decodedString)

}


