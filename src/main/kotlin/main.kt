import models.Student
import java.time.LocalDate

fun main(args: Array<String>) {

    val s1: Student = Student("Riri", "Duck", LocalDate.of(1990, 3, 12))

    println("L'etudiant : ${s1.fullname}")
    println()

    println("Email : ${s1.email}")    // Utilisation GET
    s1.email = "riri.duck@gmail.com"  // Utilisation SET
    println("Email : ${s1.email}")
    println()

    println("Matricule : ${s1.matricule}")
}