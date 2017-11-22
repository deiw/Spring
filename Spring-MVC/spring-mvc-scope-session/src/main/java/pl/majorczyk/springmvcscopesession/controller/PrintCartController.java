package pl.majorczyk.springmvcscopesession.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.majorczyk.springmvcscopesession.component.ShoppingCart;

@Controller
public class PrintCartController {

    private ShoppingCart cart;

    @Autowired
    public PrintCartController(ShoppingCart cart) {
        this.cart = cart;
    }
    @GetMapping("/print")
    public String read(){
        cart.getProducts().forEach(System.out::println);
        return "index.jsp";
    }
}
