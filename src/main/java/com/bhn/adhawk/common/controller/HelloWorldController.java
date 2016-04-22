package com.bhn.adhawk.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello Adhawks");
        return "index";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "HHello Adhawks");
        return "index";
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("home", "Home");
        return "home";
    }

    @RequestMapping(value = "/mobile", method = RequestMethod.GET)
    public String mobile(ModelMap model) {
        model.addAttribute("mobile", "Mobile");
        return "mobile";
    }

}