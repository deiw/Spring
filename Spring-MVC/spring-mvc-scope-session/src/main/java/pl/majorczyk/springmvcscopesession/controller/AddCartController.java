package pl.majorczyk.springmvcscopesession.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.majorczyk.springmvcscopesession.component.ShoppingCart;

@Controller
public class AddCartController {

    ShoppingCart cart;
    @Autowired
    public AddCartController(ShoppingCart cart){
        this.cart=cart;
    }
    @PostMapping("/add")
    public String index(@RequestParam String product, Model model){
        cart.addProduct(product);
        model.addAttribute("list",cart);
        return "index.jsp";
    }
}
