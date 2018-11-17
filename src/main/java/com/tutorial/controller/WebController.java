package com.tutorial.controller;

import com.tutorial.model.Employee;
import com.tutorial.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class WebController {
    private final EmployeeRepo repository;

    @Autowired
    public WebController(EmployeeRepo repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public HttpStatus insertEmployee(@RequestBody Employee employee) {
        boolean status = repository.save(employee) != null;
        return status? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @RequestMapping("/findall")
    public List findAll() {
        return (List) repository.findAll();
    }

    @RequestMapping("/findbyid")
    public Optional findById(@RequestParam("id") long id) {
        return repository.findById(id);
    }

    @RequestMapping("/findbylastname")
    public List fetchDataByLastName(@RequestParam("lastname") String lastName) {
        return repository.findByLastName(lastName);
    }

    @RequestMapping("/findbyage")
    public List fetchDataByAge(@RequestParam("age") int age) {
        return repository.findByAge(age);
    }
}
