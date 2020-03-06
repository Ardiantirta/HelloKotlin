// public, internal, private
class Person(val firstName: String = "Peter", val lastName: String = "Parker") {

    // public, internal, protected
    var nickName: String? = null
        set(value) {
            field = value
            println("the new nickname is $value")
        }
//        get() {
//            println("the returned value is $field")
//            return field
//        }

    // public, internal, protected
    fun printInfo() {
        val nickNameToPrint = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
}