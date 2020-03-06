interface PersonInfoProvider {
    val providerInfo: String

    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider {
    fun getSessionId(): String
}

// add open to tell compiler that you can inherit from this class
// abstract to not implement interface method, but cannot create an instance
open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    // add protected to make only available to child class.
    protected open val sessionIdPrefix = "Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

fun main() {
//    val provider = BasicInfoProvider()
    val provider = FancyInfoProvider()

    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)

    // creating anonymous class that inherit PersonInfoProvider interface
    val newProvider = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "id"
    }

    newProvider.printInfo(Person())
    newProvider.getSessionId()

    checkTypes(newProvider)

}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider !is SessionInfoProvider) {
        println("is not a session info provider")
    } else {
        println("is a session info provider")
//        (infoProvider as SessionInfoProvider).getSessionId()
        println(infoProvider.getSessionId())
    }
}