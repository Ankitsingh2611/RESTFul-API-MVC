package com.springbootweb.restapi.controllers;

import com.springbootweb.restapi.dto.EmployeeDTO;
import com.springbootweb.restapi.entities.EmployeeEntity;
//import com.springbootweb.restapi.repositories.EmployeeRepository;
import com.springbootweb.restapi.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
//        public EmployeeDTO getEmployeeByID(@PathVariable(name = "employeeId") long id){
     //   return new EmployeeDTO(id, "Ankit", "ankit@gmail.com", 23, LocalDate.of(2025,2,6) , true);
     //   return employeeRepository.findById(id).orElse(null);
//        return employeeService.getEmployeeById(id);
//    }
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
//        if (employeeDTO == null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeeDTO);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity
                        .ok(employeeDTO1)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
//    public String getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
//                                  @RequestParam(required = false) String sortBy){
//        return "Hi age" +age+ " " +sortBy;
       public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                   @RequestParam(required = false) String sortBy){
       // return employeeRepository.findAll();
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
       // return "Hello from POST";
        public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
       // return employeeRepository.save(inputEmployee);
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
       boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
       if (gotDeleted) return ResponseEntity.ok(true);
       return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId, updates);
        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
