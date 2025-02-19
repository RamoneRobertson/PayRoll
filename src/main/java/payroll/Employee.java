package payroll;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Employee {
    // Generates a unique id for DB storage
    private @Id @GeneratedValue Long id;

    // Fields for the employee class (attributes)
    private String name;
    private String role;

    // JPA requires a default constructor method
    Employee() {}

    // Regular constructor method
    Employee(String name, String role){
        this.name = name;
        this.role = role;
    }

    // Getter and setters for accessing and writing attributes
    public Long getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Override the equals method to properly compare objects based on attributes and not the memory addresses
    @Override
    public boolean equals(Object o) {
        // this == o checks if both references point to the same memory location (the object calling equals:this and the object passed as an argument : o)
        if(this == o) {
            return true;
        }

        // Checks if the argument passed is of type Employee
        if(!(o instanceof Employee)) {
            return false;
        }

        // Type cast o as an Employee type
        Employee employee = (Employee) o;

        // Compare the two objects attributes instead of memory addresses
        return Objects.equals(this.id, employee.id) && // since we type cast o now has access to the attributes
                Objects.equals(this.name, employee.name) &&
                Objects.equals(this.role, employee.role);

    }

    // When in a hash or map ect generate a unique hash for the object
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    // for logging make out more human readable instead of outputting memory addresses
    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }

}


