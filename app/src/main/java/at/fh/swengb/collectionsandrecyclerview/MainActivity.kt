package at.fh.swengb.collectionsandrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf<Student>(Student("Rob", 27), Student("George", 27), Student("Lisa", 25), Student( "David", 84))
        val secondStudent =  list.get(3)
        println (message = secondStudent.name)

        val mutableList = mutableListOf<Student>(Student("Rob", 27), Student("George", 27), Student("Lisa", 25), Student( "David", 84))
        val thirdStudent = mutableList.get (3)
        println (message = "NAME:"+ thirdStudent.name +"    SEMESTER:" + thirdStudent.currentSemester)
        mutableList.add(3, Student("Tyrion", 28)) // add at certain index
        println (message = "NAME:"+ thirdStudent.name +"    SEMESTER:" + thirdStudent.currentSemester)


        for (Student in mutableList) {
            println(Student.name + "    " + Student.currentSemester)
        }


        val set = setOf<Student>(Student("Rob", 27), Student("Rob", 27), Student("Lisa", 25))

        for (Student in set){
            println (Student.name + Student.currentSemester)
        }
        val mutableSet = mutableSetOf<Student>((Student("Rob", 27), Student("Rob", 27), Student("Lisa", 25), Student("David", 37), Student ("Nigel der Heger", 212211)))

        mutableSet.add(Student("Rob", 27))
        mutableSet.add(Student("Andre", 1212))

        for (Student in mutableSet){
            println(message = Student.name + Student.currentSemester)
        }
        for (Student in mutableSet){
                if (Student.name == "Rob") {
                    println(message = Student.name + Student.currentSemester)
                }
        }
        val ima18List = listOf(Student("Tyrion", 1), Student("Jon", 1))
        val ima17List = mutableListOf(Student("Sansa", 3), Student("Arya", 3), Student("Bran", 3))
        val studentMap = mapOf<String, List<Student>>("IMA18" to ima18List, "IMA17" to ima17List)


        
    }




}

class Student(val name: String, val currentSemester: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (name != other.name) return false
        if (currentSemester != other.currentSemester) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + currentSemester
        return result
    }

}