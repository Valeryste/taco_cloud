package com.example.taco_cloud.tacos.web;


import com.example.taco_cloud.tacos.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

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
    public String processTaco(@Valid TacoOrder tacoOrder, BindingResult bindingResult,
                              SessionStatus sessionStatus){

        if(bindingResult.hasErrors()){
            return "orderForm";
        }else {
            log.info("Order submitted: {}", tacoOrder);
            sessionStatus.setComplete();

            return "redirect:/design";
        }

    }
}
