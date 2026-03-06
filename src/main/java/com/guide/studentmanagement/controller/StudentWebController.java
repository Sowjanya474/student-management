package com.guide.studentmanagement.controller;

import com.guide.studentmanagement.model.Student;
import com.guide.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    @Autowired
    private StudentService studentService;

    // Show all students + handle search
    @GetMapping
    public String getAllStudents(@RequestParam(required = false) String search,
                                  Model model) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("students", studentService.searchByName(search));
            model.addAttribute("search", search);
        } else {
            model.addAttribute("students", studentService.getAllStudents());
        }
        model.addAttribute("newStudent", new Student());
        return "students";
    }

    // Add new student with validation
    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("newStudent") Student student,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            // If validation fails, go back to the form with error messages
            model.addAttribute("students", studentService.getAllStudents());
            return "students";
        }
        studentService.addStudent(student);
        return "redirect:/students";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
    	Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    // Save updated student with validation
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id,
                                 @Valid @ModelAttribute("student") Student student,
                                 BindingResult result) {
        if (result.hasErrors()) {
            // If validation fails, stay on edit form with error messages
            return "edit-student";
        }
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    // Delete student
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}