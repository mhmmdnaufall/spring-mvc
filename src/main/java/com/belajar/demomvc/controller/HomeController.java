package com.belajar.demomvc.controller;

import com.belajar.demomvc.dto.SearchFormData;
import com.belajar.demomvc.entity.Product;
import com.belajar.demomvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String welcome(Model model) {
        // doing something
        String messages = "Welcome to Spring MVC";
        model.addAttribute("msg", messages);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/save")
    public String save(Model model, Product product) {
        productService.addProduct(product);
        model.addAttribute("products", productService.findAll());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Model model, Product product) {
        productService.updateProduct(product);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(SearchFormData searchFormData, Model model) {
        model.addAttribute("searchForm", searchFormData);
        model.addAttribute("products", productService.findByName(searchFormData.getKeyword()));
        return "index";
    }

}
