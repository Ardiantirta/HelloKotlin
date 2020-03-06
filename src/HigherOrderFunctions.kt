// HigherOrderFunctions are functions that either return another function or take functions as parameter values.
fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if(predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("K")
}

fun getPrintPredicate(): (String) -> Boolean {
    return {
        it.startsWith("J")
    }
}

fun main() {
    val list = listOf("Kotlin", "Java", "C++", "Javascript")
    printFilteredStrings(list) {
        it.startsWith("K")
    }

    printFilteredStrings(list, predicate)

    printFilteredStrings(list, getPrintPredicate())

    printFilteredStrings(list, null)
}