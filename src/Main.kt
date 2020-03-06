
fun getGreeting(): String? {
//    return "Hello Kotlin"
    return null
}

fun sayHi(greeting:String, itemToGreet:String) = print("$greeting, $itemToGreet")

fun main() {
    println("Hello World")
    println(getGreeting())
    sayHi("Hi","Ardian")
}