package com.bhn.adhawk.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/nearby")
@SessionAttributes({"currentID", "friendPhoneNumber"})
public class nearByController {

    @RequestMapping(method = RequestMethod.GET)
    public String getNearby() {
        return "nearby/nearby";
    }

}