package com.bhn.adhawk.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/chat")
@SessionAttributes({"currentID", "friendPhoneNumber"})
public class ChatController {

    @RequestMapping(method = RequestMethod.GET)
    public String getChatPage(ModelMap modelMap) {
        modelMap.addAttribute("currentID", "cicidi");
        return "/chat/chat";
    }
    @RequestMapping(value="/chatWindow",method = RequestMethod.GET)
    public String getChatWindow(ModelMap modelMap) {
        modelMap.addAttribute("currentID", "cicidi");
        return "/chat/chatWindow";
    }


}