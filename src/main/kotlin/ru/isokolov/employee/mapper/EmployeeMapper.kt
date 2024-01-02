package ru.isokolov.employee.mapper

import org.mapstruct.Mapper
import ru.isokolov.employee.dto.EmployeeDto
import ru.isokolov.employee.model.Employee

@Mapper(componentModel = "spring")
abstract class EmployeeMapper {
    abstract fun toDto(model: Employee): EmployeeDto

    abstract fun toDto(model: List<Employee>): List<EmployeeDto>
}