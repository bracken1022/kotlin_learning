package demo

import demo.utils.SegmentDescription

class ControlFlow {
}

fun runControlFlow() {

    SegmentDescription.Segment(1, "if").show()
    var max: String
    if (1 > 2) max = "3" else "4"

    var min = if (3 > 4) {
        "5"
    } else {
        "7"
    }

    SegmentDescription.Segment(2, "when").show()
    var w: Int = 0
    when (w) {
        0, 1 -> println("0 or 1 in when")
        w.toInt() -> println("convert to String")
        in 1..10 -> println("w is in 1..10")
        !in 20 .. 100 -> println("not in 20..100")
        else -> println("null")
    }

    SegmentDescription.Segment(3, "for").show()
    for (item in 1..10) print(item)
    println()
    var arr = arrayOf(1, 2, 3, 4)
    for (item: Int in arr) {
        print(item)
    }
    println()

    for (i in 6 downTo 0 step 2) {
        print(i)
    }





}