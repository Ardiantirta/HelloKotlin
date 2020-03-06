fun sayHello(greeting: String, itemToGreet: String) = print("$greeting $itemToGreet")

fun sayHelloMultiple(greeting: String, itemsToGreet: List<String>) {
    itemsToGreet.forEach {itemToGreet ->
        println("$greeting, $itemToGreet")
    }
}

fun sayHelloSpreadSyntax(greeting: String, vararg itemsToGreet: String) {
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting, $itemToGreet")
    }
}

fun greetPerson(greeting: String = "Hello", name: String = "Kotlin") {
    println("$greeting $name")
}

fun main() {
    // arrayOf, listOf, mutableListOf
    var interestingThings = mutableListOf("Kotlin", "Programming", "Comic Books")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))

    for (interestingThing in interestingThings) {
        println(interestingThing)
    }

    // forEach without index
    interestingThings.forEach {interestingThing ->
        println(interestingThing)
    }

    // forEach with index
    interestingThings.forEachIndexed {index, interestingThing ->
        println("$interestingThing is at index $index")
    }

    interestingThings.add("Dogs")

    // mapOf, mutableMapOf
    var map = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { key, value -> println("$key -> $value")}
    map.put(4, "d")

    sayHelloMultiple("Hi", interestingThings)

    sayHelloSpreadSyntax("Hi", "Ardian", "Tirta", "Kotlin", "Flutter")

    sayHelloSpreadSyntax("Hi", *(interestingThings.toTypedArray()))

    // order insensitive
    greetPerson(name = "Ardian",  greeting = "Hi")
    greetPerson(name = "Tirta")
    greetPerson()

    sayHelloSpreadSyntax(greeting = "Hey", itemsToGreet = *(interestingThings.toTypedArray()))

    var person = Person("Ardian", "Tirta")
    person.nickName = "njir"
    person.nickName = "blokkk"

    person.printInfo()
}