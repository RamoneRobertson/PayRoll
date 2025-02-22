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

    // Handle GET request (GET all employees)
    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }

    // Handle POST request (create a new employee)
    @PostMapping("/employees")
    // When we use RequestBody Spring will automatically convert the JSON request into code to create a new employee object
    Employee newEmployee(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }

    // Single Item


    // GET one employee
    @GetMapping("/employees/{id}")
    Employee getEmployeeById(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // PUT (Change/Update an employee)
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
        // Update the name and role if an employee is found
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                // If an employee is not found create a new employee
                .orElseGet(() -> {
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        // Delte employye by finding the matching ID
        repository.deleteById(id);
    }

}
