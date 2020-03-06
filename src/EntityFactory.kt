import java.util.*

interface IdProvider {
    fun getId(): String
}

class Entity private constructor(val id: String) {

    companion object Factor: IdProvider{
        override fun getId(): String {
            return "id123"
        }

        // companion can store data
        const val id = "id"

        fun create() = Entity(id = getId())
    }
}

enum class SecondEntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

// object declaration
object SecondEntityFactory {
    fun create(type: SecondEntityType) : SecondEntity {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            SecondEntityType.EASY -> type.getFormattedName()
            SecondEntityType.MEDIUM -> type.getFormattedName()
            SecondEntityType.HARD -> type.getFormattedName()
            SecondEntityType.HELP -> type.getFormattedName()
        }
        return SecondEntity(id, name)
    }
}

class SecondEntity (val id: String, val name: String) {
    override fun toString(): String {
        return "id:$id name:$name"
    }
}

// object declaration
object ThirdEntityFactory {
    fun create(type: SecondEntityType) : ThirdEntity {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            SecondEntityType.EASY -> type.getFormattedName()
            SecondEntityType.MEDIUM -> type.getFormattedName()
            SecondEntityType.HARD -> type.getFormattedName()
            SecondEntityType.HELP -> type.getFormattedName()
        }
        return when(type) {
            SecondEntityType.EASY -> ThirdEntity.Easy(id, name)
            SecondEntityType.MEDIUM -> ThirdEntity.Medium(id, name)
            SecondEntityType.HARD -> ThirdEntity.Hard(id, name, 2f)
            SecondEntityType.HELP -> ThirdEntity.Help
        }
    }
}

// Sealed Class to define restricted class hierarchy. means define set numbers of class extending baseType
// but those class will be the only one can be extend that baseType
sealed class ThirdEntity() {
    object Help : ThirdEntity() {
        val name = "Help"
    }

    // data class or just "class"
    data class Easy(val id:String, val name: String): ThirdEntity()
    data class Medium(val id:String, val name: String): ThirdEntity()
    data class Hard(val id:String, val name: String, val multiplier: Float): ThirdEntity()
}

fun ThirdEntity.Medium.printInfo() {
    println("Medium class: $id")
}

val ThirdEntity.Medium.info: String
    get() = "some info"


fun main() {
    val entity = Entity.Factor.create()

    // can implicitly calling the "id" in companion object Factor
    entity.id

    val easySecondEntity = SecondEntityFactory.create(SecondEntityType.EASY)
    println(easySecondEntity)

    val mediumSecondEntity = SecondEntityFactory.create(SecondEntityType.MEDIUM)
    println(mediumSecondEntity)

    val newEntity: ThirdEntity = ThirdEntityFactory.create(SecondEntityType.HELP)
    val msg = when(newEntity) {
        ThirdEntity.Help -> "help class"
        is ThirdEntity.Easy -> "easy class"
        is ThirdEntity.Medium -> "medium class"
        is ThirdEntity.Hard -> "hard class"
    }

    println(msg)

    // this 2 will not equal because of the unique id
//    val entity1 = ThirdEntityFactory.create(SecondEntityType.EASY)
//    val entity2 = ThirdEntityFactory.create(SecondEntityType.EASY)

    val entity1 = ThirdEntity.Easy("id", "name")
    val entity2 = ThirdEntityFactory.create(SecondEntityType.MEDIUM)

    // check same data
    if (entity1 == entity2) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    // check same object
    if (entity1 === entity1) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    ThirdEntity.Medium("id", "name").printInfo()

    if (entity2 is ThirdEntity.Medium) {
        entity2.printInfo()
        println(entity2.info)
    }
}