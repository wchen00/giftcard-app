package com.bhn.adhawk.common.controller;

import com.bhn.adhawk.beans.User;
import com.bhn.adhawk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

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

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveOrUpdateAdHawkUser(@ModelAttribute("userForm") @Validated User user, Model model) {

        userService.saveOrUpdate(user);

        return "redirect:/users/" + user.getId();
    }

    // show update form
    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
    public String showUpdateAdHawkUserForm(@PathVariable("id") int id, Model model) {

        User user = userService.findById(id);
        model.addAttribute("userForm", user);

        return "users/userform";

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model) {


        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);

        return "users/show";

    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {

        User user = new User();

        // set default value
        user.setUserName("user123");
        user.setPassword("password");
        user.setPhoneNumber("(999) 999-9999");
        model.addAttribute("userForm", user);

        return "users/userform";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser( @ModelAttribute("userRegistration") User user, Map<String,Object> model) {

        User userRegistration = new User();

        model.put("userRegistration", userRegistration);

        return "list";

    }

}