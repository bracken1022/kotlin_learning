package demo.utils

class SegmentDescription {
    class Segment(private val index: Int, private val description: String) {
        fun show() {
            println("TypeCheck: part $index for $description")
            println()
        }
    }
}