package com.springbootweb.restapi.controllers;

import com.springbootweb.restapi.dto.EmployeeDTO;
import com.springbootweb.restapi.entities.EmployeeEntity;
//import com.springbootweb.restapi.repositories.EmployeeRepository;
import com.springbootweb.restapi.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret message : asdfg123#@jh";
//    }

 //   private final EmployeeRepository employeeRepository;

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    @GetMapping("/{employeeId}")
   // public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeId") long id){
        public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeId") long id){
     //   return new EmployeeDTO(id, "Ankit", "ankit@gmail.com", 23, LocalDate.of(2025,2,6) , true);
     //   return employeeRepository.findById(id).orElse(null);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
//    public String getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
//                                  @RequestParam(required = false) String sortBy){
//        return "Hi age" +age+ " " +sortBy;
       public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                   @RequestParam(required = false) String sortBy){
       // return employeeRepository.findAll();
        return employeeService.getAllEmployees();
    }

    @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
       // return "Hello from POST";
        public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
       // return employeeRepository.save(inputEmployee);
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping String updateEmployeeById(){
        return "Hello from Put";
    }

}
