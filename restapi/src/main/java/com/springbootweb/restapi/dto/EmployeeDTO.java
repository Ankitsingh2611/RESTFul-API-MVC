package com.springbootweb.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootweb.restapi.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
   private Long id;
   @NotBlank(message = "Name of the employee can not be blank")
   @Size(min = 3, max = 10, message = "Range of name: [3, 10]")
   private String name;
   @Email(message = "Email should be valid email")
   private String email;
   @Max(value = 80, message = "Age can not be greater than 80")
   @Min(value = 18, message = "Age can not be less than 80")
   private Integer age;

   @NotBlank(message = "Role of the employee can not be blank")
  // @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee can be USER or ADMIN")
   @EmployeeRoleValidation
   private String role; //Admin, User

   @NotNull(message = "Salary of employee should not be null") @Positive(message = "Salary of employee should be possitive")
   @Positive(message = "Salary should be possitive")
   @Digits(integer = 6, fraction = 2, message = "Salary not more that 6 digit and 2 decimal")
   @DecimalMax(value = "10000.99")
   @DecimalMin(value = "100.50")
   private Integer salary;

   @PastOrPresent(message = " DOJ can only Past or Present not future")
   private LocalDate dateOfJoining;

   @AssertTrue(message = "Employee should be active")
   @JsonProperty("isActive")
   private Boolean isActive;
}
