data class Employee(val departments: List<Department>)
data class Department(val id: Long)

fun main() {
    val employees = listOf(
        Employee(
            listOf(Department(1), Department(2), Department(3))
        ),
        Employee(
            listOf(Department(11), Department(22), Department(33))
        ),
        Employee(
            listOf(Department(111), Department(222), Department(333))
        ),
    )


    val departments: List<List<Department>> = employees.map { employee -> employee.departments }
    println(departments)

    val departmentsFlatten: List<Department> = employees.flatMap { employee -> employee.departments }
    println(departmentsFlatten)

}
