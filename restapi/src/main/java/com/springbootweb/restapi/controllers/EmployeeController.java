package com.springbootweb.restapi.controllers;

import com.springbootweb.restapi.dto.EmployeeDTO;
import com.springbootweb.restapi.entities.EmployeeEntity;
import com.springbootweb.restapi.repositories.EmployeeRepository;
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

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
   // public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeId") long id){
        public EmployeeEntity getEmployeeByID(@PathVariable(name = "employeeId") long id){
     //   return new EmployeeDTO(id, "Ankit", "ankit@gmail.com", 23, LocalDate.of(2025,2,6) , true);
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
//    public String getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
//                                  @RequestParam(required = false) String sortBy){
//        return "Hi age" +age+ " " +sortBy;
       public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                   @RequestParam(required = false) String sortBy){
        return employeeRepository.findAll();
    }

    @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
       // return "Hello from POST";
        public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping String updateEmployeeById(){
        return "Hello from Put";
    }

}
