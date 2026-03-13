package spareparts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import spareparts.model.SparePart;
import spareparts.model.Order;
import spareparts.repository.SparePartRepository;
import spareparts.repository.OrderRepository;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private SparePartRepository partRepo;

    @Autowired
    private OrderRepository orderRepo;

    // Show dashboard with available parts
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<SparePart> parts = partRepo.findAll();
        model.addAttribute("parts", parts);

        return "customer-dashboard";
    }

    // Buy spare part
    @PostMapping("/buy")
    public String buyPart(@RequestParam Long partId,
                          @RequestParam int qty) {

        SparePart part = partRepo.findById(partId).orElse(null);

        if (part != null && qty > 0 && qty <= part.getQuantity()) {

            part.setQuantity(part.getQuantity() - qty);
            partRepo.save(part);

            Order order = new Order();
            order.setPartName(part.getName());
            order.setPrice(part.getPrice());
            order.setQuantity(qty);

            orderRepo.save(order);
        }

        return "redirect:/customer/dashboard";
    }

    // View purchased parts
    @GetMapping("/orders")
    public String viewOrders(Model model) {

        List<Order> orders = orderRepo.findAll();
        model.addAttribute("orders", orders);

        return "orders";
    }
}