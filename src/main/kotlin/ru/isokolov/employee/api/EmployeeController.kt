package ru.isokolov.employee.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.isokolov.employee.dto.EmployeeDto
import ru.isokolov.employee.dto.RequestCreateEmployeeDto
import ru.isokolov.employee.mapper.EmployeeMapper
import ru.isokolov.employee.model.NewEmployee
import ru.isokolov.employee.service.EmployeeService
import java.util.UUID

@RestController
@RequestMapping("employees")
class EmployeeController(
    private val employeeService: EmployeeService,
    private val mapper: EmployeeMapper
) {
    @PostMapping(
        path = ["", "/"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun create(
        @RequestBody
        dto: RequestCreateEmployeeDto
    ): ResponseEntity<EmployeeDto> {
        val employee = employeeService.save(NewEmployee(name = dto.name))
        return ResponseEntity(mapper.toDto(employee), HttpStatus.CREATED)
    }

    @GetMapping(
        path = ["/{id}"],
        produces = ["application/json"]
    )
    fun getById(
        @PathVariable
        id: UUID
    ): ResponseEntity<EmployeeDto> {
        val employee = employeeService.getById(id)
        return if (employee == null) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity(mapper.toDto(employee), HttpStatus.OK)
        }
    }

    @GetMapping(
        path = ["", "/"],
        produces = ["application/json"]
    )
    fun getAll(): ResponseEntity<List<EmployeeDto>> {
        val employeeList = employeeService.getAll()
        return if (employeeList.isEmpty()) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity(mapper.toDto(employeeList), HttpStatus.OK)
        }
    }
}