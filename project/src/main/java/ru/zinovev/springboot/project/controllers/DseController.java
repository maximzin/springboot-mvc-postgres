package ru.zinovev.springboot.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import ru.zinovev.springboot.project.models.Dse;
import ru.zinovev.springboot.project.models.Operation;
import ru.zinovev.springboot.project.models.RouteString;
import ru.zinovev.springboot.project.services.DseService;
import ru.zinovev.springboot.project.services.OperationService;
import ru.zinovev.springboot.project.services.RouteStringService;

@Controller
@RequestMapping("/dse")
public class DseController {

    private final DseService dseService;
    
    private final RouteStringService routeStringService;
    
    private final OperationService operationService;

    @Autowired
    public DseController(DseService dseService, RouteStringService routeStringService
    					, OperationService operationService) {
        this.dseService = dseService;
        this.routeStringService = routeStringService;
        this.operationService = operationService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("details", dseService.findAll());
        return "dse/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("dse", dseService.findOne(id));
        model.addAttribute("routestrings", routeStringService.findByIdDse(id));
        return "dse/show";
    }

    @GetMapping("/newdse")
    public String newDse(@ModelAttribute("dse") Dse dse) {
        return "dse/newdse";
    }
    
    @GetMapping("/{id}/editroute/newoper")
    public String newOper(Model model, @ModelAttribute("routestring") RouteString routestring,
    					@ModelAttribute("operation") Operation operation, @PathVariable("id") int id) {
    	model.addAttribute("dse", dseService.findOne(id));
        model.addAttribute("operations", operationService.findAll());
    	return "dse/newoper";
    }

    @PostMapping()
    public String createDse(@ModelAttribute("dse") @Valid Dse dse,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "dse/newdse";

        dseService.saveDse(dse);
        return "redirect:/dse";
    }
    
    @PostMapping("/{id}/newoper")
    public String createOper(@PathVariable("id") int id, @ModelAttribute("routestring") @Valid RouteString routestring,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "dse/newoper";
        
        routeStringService.saveRouteString(routestring);
        return "redirect:/dse/{id}/editroute";
    }

    @GetMapping("/{id}/editdse")
    public String editDse(Model model, @PathVariable("id") int id) {
        model.addAttribute("dse", dseService.findOne(id));
        return "dse/editdse";
    }
    
    @GetMapping("/{id}/editroute")
    public String editRoute(Model model, @PathVariable("id") int id) {
        model.addAttribute("dse", dseService.findOne(id));
        model.addAttribute("routestrings", routeStringService.findByIdDse(id));
        return "dse/editroute";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("dse") @Valid Dse dse, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "dse/editdse";

        dseService.updateDse(id, dse);
        return "redirect:/dse/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteDse(@PathVariable("id") int id) {
    	dseService.deleteDse(id);
        return "redirect:/dse";
    }
    
    @DeleteMapping("/{id1}/editroute/{id2}")
    public String deleteRouteString(@PathVariable("id1") int id1, @PathVariable("id2") int id2) {
    	routeStringService.deleteRouteString(id2);
        return "redirect:/dse/{id1}/editroute";
    }
}
