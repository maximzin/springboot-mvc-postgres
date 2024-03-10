package ru.zinovev.springboot.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import ru.zinovev.springboot.project.models.Operation;
import ru.zinovev.springboot.project.services.OperationService;

@Controller
@RequestMapping("/operations")
public class OperationController {
	
    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("operations", operationService.findAll());
        return "operations/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("operation", operationService.findOne(id));
        return "operations/show";
    }

    @GetMapping("/new")
    public String newOperation(@ModelAttribute("operation") Operation operation) {
        return "operations/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("operation") @Valid Operation operation,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "operations/new";
        operationService.saveOperation(operation);
        return "redirect:/operations";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("operation", operationService.findOne(id));
        return "operations/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("operation") @Valid Operation operation, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "operations/edit";

        operationService.updateOperation(id, operation);
        return "redirect:/operations";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
    	operationService.deleteOperation(id);
        return "redirect:/operations";
    }
}
