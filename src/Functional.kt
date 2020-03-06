fun main() {
    val list = listOf("Kotlin", "Java", "C++", "Javascript", null)

    list
        .filterNotNull()
        .filter { it.startsWith("K") }
        .map { it.length }
        .forEach { println(it) }

    list
        .filterNotNull()
        .take(3)
        .forEach { println(it) }

    list
        .filterNotNull()
        .associate { it to it.length }
        .forEach {
            println("${it.value}, ${it.key}")
        }

    var map = list
        .filterNotNull()
        .associate { it to it.length }

    val language = list.first()
    println(language)

    val otherLanguage = list
        .filterNotNull()
        .last()

    println(otherLanguage)

    val otherOtherLanguage = list
        .filterNotNull()
        .find { it.startsWith("Java") }
    println(otherOtherLanguage)

    val x = list
        .filterNotNull()
        .find { it.startsWith("foo") }
        .orEmpty()
    println(x)
}