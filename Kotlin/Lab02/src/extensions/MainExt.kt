package dictionary.extensions

fun main()
{
    val name = "Vancza Tibor"
    println(name.monogramOfName())

}

//extension feladatok ide.

fun String.monogramOfName() = this.split(" ").map { it.first().toUpperCase() }.joinToString("")

fun List<String>.longestString() = this.joinToString { "#" }

//lista extension function
//