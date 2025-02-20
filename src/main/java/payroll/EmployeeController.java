package payroll;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController tells Spring that this class is a controller
@RestController
class EmployeeController {

    // initialize a repository
    private final EmployeeRepository repository;

    // Constructor method to initialize repository
    EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    // Handle GET request (all entities)
    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }
}
