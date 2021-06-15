package models

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class Student(val firstname: String, val lastname: String, val birthdate: LocalDate) {

    var email: String? = null
        set(value) {
            if (value != null && !Regex("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\$").matches(value)) {
                throw Throwable("Bad E-mail !")
            }
            field = value
        }

    val fullname: String
        get() = "$firstname $lastname"

    val matricule: String
        get() {
            val valFirstname = this.firstname.substring(0, 2)
            val valLastname = this.lastname.take(2)
            val valBirthdate = this.birthdate.format(DateTimeFormatter.ofPattern("YYMMdd"))
            return (valFirstname + valLastname + valBirthdate).lowercase()
        }

    val age: Int
        get() {
            val period: Period = Period.between(birthdate, LocalDate.now())
            return period.years
        }

    constructor(firstname: String, lastname: String, birthdate: LocalDate, email: String)
            : this(firstname, lastname, birthdate) {
        this.email = email
    }

    fun followCourse(course: String) {
        println("$fullname suit le cours de $course")
    }

    fun studyCourse(course: String) {
        println("$fullname etudie le cours de $course")
    }

    fun guindailler() {
        println("$fullname guindaille toute la nuit")
    }

    fun sendMailToTeacher(teacher: Teacher) {
        println("$fullname envoie un mail à ${teacher.fullname}")
        teacher.recievedMail()
    }
}