package demo

class TypeCheck {

    class Segment(private val index: Int, private val description: String) {
        fun show() {
            println("TypeCheck: part $index for $description")
            println()
        }
    }

}



fun runTypeCheck() {
    TypeCheck.Segment(1, "is and !is").show()

    val one: Any = 1
    if (one !is String) {
        println("1 is not a String")
    }

    TypeCheck.Segment(1, "Smart cast").show()

    val oneStr: Any = "1"
    if (oneStr is String) {
        println("the length of String 1 is ${oneStr.length}")
    }

    var castOne = oneStr !is String || oneStr.length == 0
    println("x is automatically cast to String on the right-hand side of `&& or ||` in the expression: var castOne = oneStr !is String || oneStr.length == 0")
    println("The result is $castOne")


    println("Smart casts work for when expressions and while loops ")
    val two: Any = 22;
    when (two) {
        is Int -> println("two is Int")
        is String -> println("two is String")
    }

    try {
        val three: String? = two as String?
    } catch (ex: Exception) {
        println("Unsafe cast happened for: val three: String? = two as String?")
    }

    val four: String? = two as? String
    println("Safe cast for val four: String? = two as? String")
}