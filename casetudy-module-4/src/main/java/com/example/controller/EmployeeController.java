package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.EmployeeDto;
import com.example.model.entity.*;
import com.example.model.repository.*;
import com.example.model.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;

    @Autowired
    DivisionService divisionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    AppUserService appUserService;

    @GetMapping("/create")
    public String createEmployeePage(Model model) {
        this.getListSecondary(model);
        model.addAttribute("employeeDto", new EmployeeDto());
        return "/furama/employee/create";
    }

    private void getListSecondary(Model model) {
        List<Position> positionList = positionService.findAll();
        model.addAttribute("positionList", positionList);
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("educationDegreeList", educationDegreeList);
        List<AppUser> appUserList = appUserService.findAll();
        model.addAttribute("appUserList", appUserList);
    }

    @PostMapping("/create")
    public String saveCustomer(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            this.getListSecondary(model);
            return "/furama/employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "create success, employee: " + employee.getEmployeeName());
            return "redirect:/employee/list";
        }


    }

    @GetMapping("/list")
    public String showCustomerList(@RequestParam("keyWord") Optional<String> keyWord, @PageableDefault(value = 6) Pageable pageable, Model model) {
        Page<Employee> employees;
        String key = "";
        if (keyWord.isPresent()) {
            employees = employeeService.findByName(keyWord.get(), pageable);
            key = keyWord.get();
        } else {
            employees = employeeService.findAll(pageable);
        }
        model.addAttribute("employeeList", employees);
        model.addAttribute("keyWord", key);
        return "/furama/employee/list";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam int idEmployeeDelete, RedirectAttributes redirectAttributes) throws SQLException {
        String name = employeeService.findById(idEmployeeDelete).getEmployeeName();
        employeeService.remove(idEmployeeDelete);
        redirectAttributes.addFlashAttribute("message", "delete success employee "+ name);
        return "redirect:/employee/list";
    }

    @PostMapping("/edit")
    public String editCustomer(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws SQLException {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            this.getListSecondary(model);
            return "/furama/employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("message", "update success, employee: " + employee.getEmployeeName());
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable int id, Model model) throws SQLException {
        this.getListSecondary(model);
        model.addAttribute("employeeDto", employeeService.findById(id));
        return "furama/employee/edit";
    }
}
