package com.bhn.adhawk.common.controller;

import com.bhn.adhawk.beans.User;
import com.bhn.adhawk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.QueryParam;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserManagementController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showAllAdHawkUsers(Model model) {

        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    // show update form
    @RequestMapping(value = "/share", method = RequestMethod.GET)
    public String shareBhnCredit(@QueryParam("id") int id, Model model) {

        System.out.println("shareBhnCredit : user to find :"+id);
        User user = userService.findById(id);

        System.out.println("shareBhnCredit : user to find :"+user.getUserName());
        user.setShareFrom(user.getId());
        model.addAttribute("user", user);

        return "users/userform";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveAndUpdateCredit(@ModelAttribute(value="user") User user, Model model) {

        System.out.println("user "+user.getBhnCredit()+":"+user.getPhoneNumber()+":"+user.getShareFrom());

        userService.saveOrUpdate(user);
        return "users/userform";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser( @ModelAttribute("userRegistration") User user, Map<String,Object> model) {

        User userRegistration = new User();
        model.put("userRegistration", userRegistration);

        return "list";

    }

}