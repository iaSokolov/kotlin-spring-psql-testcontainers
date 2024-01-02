package ru.isokolov.employee.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.isokolov.employee.dto.EmployeeDto;
import ru.isokolov.employee.model.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-02T17:26:40+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from kotlin-annotation-processing-gradle-1.9.21.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class EmployeeMapperImpl extends EmployeeMapper {

    @Override
    public EmployeeDto toDto(Employee model) {
        if ( model == null ) {
            return null;
        }

        UUID id = null;
        String name = null;

        id = model.getId();
        name = model.getName();

        EmployeeDto employeeDto = new EmployeeDto( id, name );

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> toDto(List<Employee> model) {
        if ( model == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( model.size() );
        for ( Employee employee : model ) {
            list.add( toDto( employee ) );
        }

        return list;
    }
}
