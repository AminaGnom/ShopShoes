package com.example.demo.controllers;

import com.example.demo.models.Shoes;
import com.example.demo.repo.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class ShoesController {
    @Autowired
    private ShoesRepository shoesRepository;

    @GetMapping("/shs")
    public String blogMain(Model model)
    {
        Iterable<Shoes> shoes = shoesRepository.findAll();
        model.addAttribute("shoes", shoes);
        return "shoes-main";
    }

    @GetMapping("/shoes/add")
    public String ShoesAdd(Model model)
    {
        return "shoes-add";
    }

    @PostMapping("/shoes/add")
    public String ShoesPostAdd(@RequestParam(defaultValue = "0") String brand,
                                 @RequestParam(defaultValue = "0000.00.00") Date releaseDate,
                                 @RequestParam(defaultValue = "false") boolean season,
                                 @RequestParam(defaultValue = "0") double weight,
                                 @RequestParam(defaultValue = "0") int article, Model model)
    {

        Shoes shoes = new Shoes(brand, releaseDate, season, weight, article);
        shoesRepository.save(shoes);
        return "redirect:/";
    }

    @GetMapping("/shoes/filter")
    public String shoesFilter(Model model)
    {
        return "shoes-filter";
    }

    @PostMapping("/shoes/filter/result")
    public String shoesResult(@RequestParam String brand, Model model)
    {

        List<Shoes> result = shoesRepository.findByBrandContains(brand);
        List<Shoes> result1 = shoesRepository.findByBrand(brand);
        model.addAttribute("result", result);
        return "shoes-filter";
    }
}

