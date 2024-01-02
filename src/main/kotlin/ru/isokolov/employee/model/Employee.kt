package ru.isokolov.employee.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Employee(
    @Id
    @Column(name = "id")
    var id: UUID,

    @Column(name = "name")
    var name: String
)