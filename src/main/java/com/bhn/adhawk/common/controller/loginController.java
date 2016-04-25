package com.bhn.adhawk.common.controller;

import com.bhn.adhawk.beans.Request;
import com.bhn.adhawk.beans.User;
import com.bhn.adhawk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.ws.rs.QueryParam;

@Controller
@RequestMapping("/login")
@SessionAttributes({"currentID", "friendPhoneNumber"})
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage(ModelMap modelMap) {
//        User user = new User();
//        user.setId(phoneNumber);
//        userService.saveOrUpdate(user);
        Request request = new Request();
        modelMap.addAttribute("request", request);
        return "login";
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public String getIndexPage(@QueryParam("request") Request request, ModelMap modelMap) {
//        User user = new User();
//        user.setId(phoneNumber);
//        userService.saveOrUpdate(user);
        modelMap.addAttribute("currentID", request.getPhonenumber());
        return "chat/chat";
    }

}