package spareparts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spareparts.model.SparePart;
import spareparts.repository.SparePartRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SparePartRepository partRepo;

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("parts", partRepo.findAll());
        return "dashboard";
    }

    @PostMapping("/save")
    public String savePart(@RequestParam String name,
                           @RequestParam double price,
                           @RequestParam int quantity){

        SparePart part = new SparePart();
        part.setName(name);
        part.setPrice(price);
        part.setQuantity(quantity);

        partRepo.save(part);

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deletePart(@PathVariable Long id){
        partRepo.deleteById(id);
        return "redirect:/admin/dashboard";
    }

}