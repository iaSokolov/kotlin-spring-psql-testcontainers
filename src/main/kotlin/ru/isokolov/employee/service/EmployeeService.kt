package ru.isokolov.employee.service

import org.springframework.stereotype.Service
import ru.isokolov.employee.model.Employee
import ru.isokolov.employee.model.NewEmployee
import ru.isokolov.employee.repository.EmployeeRepository
import java.util.*

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository
) {
    fun getById(id: UUID): Employee? = employeeRepository.getReferenceById(id)

    fun getAll(): List<Employee> = employeeRepository.findAll()

    fun save(newEmployee: NewEmployee): Employee {
        return employeeRepository.save(
            Employee(
                id = UUID.randomUUID(),
                name = newEmployee.name
            )
        )
    }
}