package com.twentythree.controller;

import com.twentythree.model.Employee;
import com.twentythree.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@RestController
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    //Displays list of employees
    @GetMapping("/")
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        logger.info("I am here");
        logger.info("Employee Count " + employeeService.getAllEmployeees().size());
        model.addAttribute("employeesList", employeeService.getAllEmployeees());
        return "index";
    }

    //Displays employee form
    @GetMapping("/addEmployee")
    public String saveEmployee(Model model){
        logger.info("I am here Employee Form");
        // Create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    //Posts request for employee
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/editEmployee/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model){

        //get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee,
                                 BindingResult result, Model model){
        if(result.hasErrors()){
            employee.setId(id);
            return "update-employee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") long id){

        //call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/index";
    }


}
