enum class ShapeType(type:String) {
    CIRCLE("CIRCLE"),
    RECTANGLE("REACTANGLE"),
    SPHERE("SPHERE")
}

abstract class Shape {
    abstract fun getName(): String
}

interface TwoDimensional {
    fun calculateArea(): Double
}

interface ThreeDimensional {
    fun calculateVolume(): Double
}

class Circle(private val radius: Double) : Shape(), TwoDimensional {
    override fun getName(): String = "${ShapeType.CIRCLE}"

    override fun calculateArea(): Double = Math.PI * radius * radius
}

class Rectangle(private val length: Double, private val width: Double) : Shape(), TwoDimensional {
    override fun getName(): String = "${ShapeType.RECTANGLE}"

    override fun calculateArea(): Double = length * width
}

class Sphere(private val radius: Double) : Shape(), TwoDimensional, ThreeDimensional {
    override fun getName(): String = "${ShapeType.SPHERE}"

    override fun calculateArea(): Double = 4 * Math.PI * radius * radius

    override fun calculateVolume(): Double = (4.0 / 3.0) * Math.PI * radius * radius * radius
}

fun main() {
    val circle = Circle(5.0)
    val rectangle = Rectangle(4.0, 6.0)
    val sphere = Sphere(3.0)
    val shapes: Array <Shape> = arrayOf(
        circle,
        rectangle,
        sphere
    )
    shapes.forEach {
        val name = it.getName()

        when(it) {
            is TwoDimensional -> println(name + ": " + it.calculateArea())
            is ThreeDimensional -> println(name + ": " + it.calculateVolume())
            else -> throw Exception("Error")

        }
    }




//    println("${circle.getName()} Area: ${circle.calculateArea()}")
//    println("${rectangle.getName()} Area: ${rectangle.calculateArea()}")
//    println("${sphere.getName()} Area: ${sphere.calculateArea()}, Volume: ${sphere.calculateVolume()}")
}
