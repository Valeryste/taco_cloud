package com.example.taco_cloud.tacos.web;


import com.example.taco_cloud.tacos.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class TacoOrderController {

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processTaco(TacoOrder tacoOrder, SessionStatus sessionStatus){
        log.info("Order submitted: {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/design";

    }
}
