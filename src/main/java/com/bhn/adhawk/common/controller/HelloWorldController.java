package com.bhn.adhawk.common.controller;

import com.bhn.adhawk.beans.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        Request request = new Request();
//        model.addAttribute("greeting", "HHello Adhawks");
        model.addAttribute("request", request);
        return "login";
    }

    @RequestMapping(value = "/invite/{code}", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        Request request = new Request();
//        model.addAttribute("greeting", "HHello Adhawks");
        model.addAttribute("request", request);
        return "login";
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