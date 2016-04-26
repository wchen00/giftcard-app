package com.bhn.adhawk.common.controller;

import com.bhn.adhawk.beans.Request;
import com.bhn.adhawk.service.SmsService;
import com.bhn.adhawk.service.TransferService;
import com.bhn.adhawk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/redeem")
@SessionAttributes({"currentID", "friendPhoneNumber", "request"})
public class RedeemController {

    @Autowired
    UserService userService;
    @Autowired
    TransferService transferService;
    @Autowired
    SmsService smsService;

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String redeemAction(@ModelAttribute(value = "request") Request request, ModelMap modelMap) {
//        Request request = new Request();
        String redeelValue = request.getMerchant() + " " + request.getRedeemAmount();
        modelMap.addAttribute("request", request);
        modelMap.addAttribute("qrcodevalue", redeelValue);
        return "users/redeemPage";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getContact(@ModelAttribute(value = "request") Request request, ModelMap modelMap) {
//        Request request = new Request();
        modelMap.addAttribute("request", request);
        modelMap.addAttribute("qrcodevalue", "qrcodevalue");
        return "users/redeem";
    }

    @ModelAttribute("allOptions")
    public String[] allOptions() {

        ArrayList<String> allOptions = new ArrayList<String>();

        allOptions.add("BestBuy");
        allOptions.add("Safeway");
        allOptions.add("PetSmart");
        allOptions.add("Starbucks");
        return allOptions.toArray(new String[allOptions.size()]);
    }
}