package models

import java.time.LocalDate
import java.time.Period

class Teacher(val firstname: String, val lastname: String, val birthdate: LocalDate, email: String) {

    var email: String? = null
        set(value) {
            if (value != null && !Regex("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\$").matches(value)) {
                throw Throwable("Bad E-mail !")
            }
            field = value
        }

    val fullname: String
        get() = "$firstname $lastname"


    val age: Int
        get() {
            val period: Period = Period.between(birthdate, LocalDate.now())
            return period.years
        }

    // Méthode d'initialisation, qui permet d'executer du code après l'utilisation du Ctor primaire
    init {
        // Permet l'utilisation du Setter
        this.email = email
    }

    fun teach(course: String) {
        println("$fullname donne de cours de $course")
    }

    fun recievedMail() {
        println("$fullname a recu un mail")
    }
}