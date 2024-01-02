package ru.isokolov.employee.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.isokolov.employee.model.Employee
import java.util.UUID

interface EmployeeRepository: JpaRepository<Employee, UUID>