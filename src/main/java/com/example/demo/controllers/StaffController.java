package com.example.demo.controllers;

import com.example.demo.models.Staff;
import com.example.demo.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
@Controller

public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/stf")
    public String blogMain(Model model)
    {
        Iterable<Staff> staff = staffRepository.findAll();
        model.addAttribute("staff", staff);
        return "staff-basic";
    }

    @GetMapping("/staff/add")
    public String StaffAdd(Model model) {
        return "staff-add";
    }

    @PostMapping("/staff/add")
    public String staffPostAdd(@RequestParam(defaultValue =  "0")String fio,
                               @RequestParam(defaultValue = "false")boolean work,
                               @RequestParam(defaultValue = "0") double wages,
                               @RequestParam(defaultValue = "0") int bank,
                               @RequestParam(defaultValue = "2022.11.22") Date birth, Model model)
    {
        Staff staff = new Staff(fio, birth, work, wages, bank);
        staffRepository.save(staff);
        return "redirect:/";
    }

    @GetMapping("/staff/filter")
    public String staffFilter(Model model)
    {
        return "staff-filter";
    }

    @PostMapping("/staff/filter/result")
    public String blogResult(@RequestParam String fio, Model model)
    {
        List<Staff> result = staffRepository.findByFioContains(fio);
        List<Staff> result1 = staffRepository.findByFio(fio);
        model.addAttribute("result", result);
        return "staff-filter";
    }












}
