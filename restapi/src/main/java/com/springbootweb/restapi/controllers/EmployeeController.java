package com.springbootweb.restapi.controllers;

import com.springbootweb.restapi.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret message : asdfg123#@jh";
//    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeId") long id){
        return new EmployeeDTO(id, "Ankit", "ankit@gmail.com", 23, LocalDate.of(2025,2,6) , true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                  @RequestParam(required = false) String sortBy){
        return "Hi age" +age+ " " +sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
       // return "Hello from POST";
    }

    @PutMapping String updateEmployeeById(){
        return "Hello from Put";
    }

}
