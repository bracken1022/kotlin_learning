package demo

import javax.naming.Context
import javax.swing.text.AttributeSet

class ClazzLearning(name: String, age: Int = 18) {

    val upperName = name.uppercase()

    private var firstName: String
    private var lastName: String
    private var age: Int

    init {
        firstName = name.split(" ")[0]
        lastName = name.split(" ")[1]
        this.age = age
    }

    constructor(name: String) : this(name, 26)


    fun fullName(): String {
        return "$firstName:$lastName"
    }

    fun showAge(): String {
        return "${this.age}"
    }
}

open class People(name: String) {

    private var fullName: String

    init {
        fullName = name
    }

    fun showFullName() {
        println(fullName)
    }
}

class Teacher(name: String) : People(name) {

}

// Abstract class
abstract class Polygon {
    abstract fun draw()
}

open class Triangle : Polygon() {

    val borderColor: String get() = "black"

    override fun draw() {
        println("draw a class")
    }

    open fun fill() {
        println("private function")
    }
}

class IsoscelesTriangle : Triangle() {

    val fillColor: String get() = super.borderColor

    override fun draw() {
        super.draw()
        println("draw isosceles triangle")
    }

    override fun fill() {
        println("fill func in ios")
    }

    inner class Filter {
        fun fill() { println("Filling") }

        fun drawAndFill() {
            super@IsoscelesTriangle.fill()
            fill()
        }
    }

}

open class View {
    constructor(ctx: Context)

    constructor(ctx: Context, attrs: AttributeSet)
}

class MyView : View {
    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}

interface NewShape {
    val vertexCount: Int
}

class NewRectangle(override val vertexCount: Int = 4) : NewShape

class NewPolygon : NewShape {
    override var vertexCount: Int = 0
}

open class Animal {
    open fun draw() {
        println("draw an animal")
    }
}

interface Wing {
    fun draw() {
        println("Wing in interface")
    }
}

class Bird() : Animal(), Wing {

    var name: String = "Holmes"
    val eyes: Int
        get() = 1

    var legs: Int = 2
        get() = 1
        set(value) {
            field = 2 * value
        }

    override fun draw() {
        super<Animal>.draw()
        super<Wing>.draw()
    }


}

// SAM conversions

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}




fun runClazz() {
    val cla = ClazzLearning("Zhi Jin", 33)
    println(cla.fullName())
    println(cla.upperName)
    println(cla.showAge())

    val cla2 = ClazzLearning("Zhi Jin")
    println(cla2.showAge())

    val tri = Triangle()
    tri.draw()

    val teacher = Teacher("John")
    teacher.showFullName()

    val triangle = IsoscelesTriangle()
    triangle.draw()
    triangle.fill()
    triangle.Filter().drawAndFill()

    val bird = Bird()
    bird.draw()
    println(bird.name)

    val isEvent = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 ==0
        }
    }
    println("is event for 9: ${isEvent.accept(9)}")

    val isEventLambda = IntPredicate { i -> i % 2 ==0 }
    println("is event for 11: ${isEventLambda.accept(9)}")

}