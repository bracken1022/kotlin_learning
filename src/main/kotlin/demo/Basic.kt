package demo


fun printToStandard() {
    print("Hello")
    print("\n")

    println("World")
}

fun funcWithArg(a: Int, b: Int): Int {
    return a + b
}

fun funcBodyAsExpression(a: Int, b: Int) = a * b

fun segment(segment: Int) {
    println("")
    println("Part: $segment")
}

fun describe(obj: Any): String = when (obj) {
    1 -> "one"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a String"
    else -> "Unknown"
}

fun parseIntA(num: String): Int? {
    return try {
        num.toInt()
    } catch (ex: Exception) {
        null
    }
}

fun getStringLength(obj: Any): Int? {
    return if (obj is String) obj.length else null
}

fun runBasic() {

    //1
    segment(1)
    printToStandard()

    //2
    segment(2)
    val funcWithArg = funcWithArg(1, 2)
    println(funcWithArg)

    //3
    segment(3)
    val funcBodyAsExpression = funcBodyAsExpression(2, 2)
    println(funcBodyAsExpression)

    //4
    segment(4)
    returnNoMeaningfulValue(1, 2)

    //5
    segment(5)
    val a: Int = 2
    val b = 2
    val c: Int
    c = 10
    println("Read only variables are: $a, $b, $c")

    //6
    segment(6)
    var x = 5
    x += 1
    println(x)

    //7 class
    segment(7)
    val rectangle = Rectangle(5.0, 2.0)
    println("The perimeter is ${rectangle.perimeter}")


    //8 String templates
    segment(8)
    var n = 1
    val s1 = "n is $n"
    var m = 2
    val s2 = "${s1.replace("is", "was")}, but now is $m"
    println(s2)

    //9 conditional expression
    segment(9)
    if (n > m) {
        println("N is bigger than M.")
    } else {
        println("N is smaller than M.")
    }

    if (n > m) println("N is bigger than M.") else println("N is smaller than M.")

    //10 for loop
    segment(10)
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        print("$item ")
    }

    println("")
    for (index in items.indices) {
        print("$index: ${items[index]} ")
    }
    println("")

    //11 when expression
    segment(11)
    println(describe(1))
    println(describe("Hello"))
    println(describe(11.1))
    println(describe(Long.MIN_VALUE))
    println(describe(listOf(1, 2)))

    //12 ranges
    segment(12)
    val max = 10
    for (i in 1..max) {
        print("$i ")
    }
    println("")

    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is not in index of list")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices")
    }

    for (x in 1..10 step 2) {
        print("$x ")
    }
    println()

    for (x in 9 downTo 0 step 3) {
        print("$x ")
    }
    println()

    //12 collections
    segment(13)
    when {
        "apple" in items -> println("apple")
        "orange" in items -> println("juicy")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { print("$it ") }
    println()

    //14 Nullable values and null checks
    segment(14)
    when {
        parseIntA("a") == null -> {
            println("Parse failed")
        }
    }

    //15 Type checks and automatic casts
    segment(15)
    println(getStringLength("apple"))
    println(getStringLength(11))
}

open class Shape

class Rectangle(height: Double, length: Double) : Shape() {
    var perimeter = (height + length) * 2
}


fun returnNoMeaningfulValue(a: Int, b: Int): Unit {
    println("The input values are: $a, $b")
}
