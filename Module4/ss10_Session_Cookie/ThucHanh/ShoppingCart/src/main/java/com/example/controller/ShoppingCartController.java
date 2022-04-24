package com.example.controller;

import com.example.model.Cart;
import com.example.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        System.out.println("Count: " + cart.countProductQuantity());
        System.out.println("Shopping: ");
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            System.out.println(entry.getKey().getId() + " ");
            System.out.println(entry.getKey().getName() + "\n");
        }
        return  new ModelAndView("cart", "cart", cart);
    }
}
