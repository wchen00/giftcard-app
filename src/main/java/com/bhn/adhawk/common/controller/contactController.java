package com.bhn.adhawk.common.controller;

import com.bhn.adhawk.beans.Request;
import com.bhn.adhawk.service.SmsService;
import com.bhn.adhawk.service.TransferService;
import com.bhn.adhawk.service.UserService;
import com.twilio.sdk.TwilioRestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.ws.rs.QueryParam;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/contact")
@SessionAttributes({"currentID", "friendPhoneNumber", "request"})
public class ContactController {

    @Autowired
    UserService userService;
    @Autowired
    TransferService transferService;
    @Autowired
    SmsService smsService;

    @RequestMapping(method = RequestMethod.GET)
    public String getContact(ModelMap modelMap) {
        Request request = new Request();
        modelMap.addAttribute("request", request);
        return "contact/contact";
    }

    @RequestMapping(value = "/friendRequest", method = RequestMethod.POST)
    public String friendRequest(@ModelAttribute(value = "request") Request request, ModelMap modelMap) {
        String friendPhone = request.getFriendPhonenumber();
        String amount = request.getAmount();
        String currentID = (String) modelMap.get("currentID");
        transferService.transfer(currentID, friendPhone, Double.valueOf(amount));
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
// Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();
// Using DateFormat format method we can create a string
// representation of a date with the defined format.
        String reportDate = df.format(today);
        String message = "Hi someone send you a gift card at" + today;
        try {
            smsService.sendSMS(friendPhone, request.getMessage());
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute("friendPhoneNumber", message);
        modelMap.addAttribute("request", request);
        return "chat/chatWindow";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute(value = "request") Request request, ModelMap modelMap) {
//        String friendPhone = request.getPhonenumber();
//        String amount = request.getAmount();
//        String currentID = (String) modelMap.get("currentID");
//        transferService.transfer(currentID, friendPhone, Double.valueOf(amount));
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//// Get the date today using Calendar object.
//        Date today = Calendar.getInstance().getTime();
//// Using DateFormat format method we can create a string
//// representation of a date with the defined format.
//        String reportDate = df.format(today);
//        String message = "Hi someone send you a gift card at" + today;
//        try {
//            smsService.sendSMS(friendPhone, request.getMessage());
//        } catch (TwilioRestException e) {
//            e.printStackTrace();
//        }
        modelMap.addAttribute("request", request);
        return "contact/friendRequest";
    }


    @RequestMapping(value = "/sendRequest/", method = RequestMethod.POST)
    public String sendRequest(
            @QueryParam("message") String message,
            @QueryParam("amount") double amount,
            ModelMap modelMap) {
        String currentID = (String) modelMap.get("currentID");
        String friendPhoneNumber = (String) modelMap.get("friendPhoneNumber");
        try {
            smsService.sendSMS(friendPhoneNumber, message);
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }
        transferService.transfer(currentID, userService.findByPhone(friendPhoneNumber).getId(), amount);
        return "chatWindow";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String sendRequestTest(ModelMap modelMap) {
        String currentID = (String) modelMap.get("currentID");

        String friendPhoneNumber = (String) modelMap.get("friendPhoneNumber");
        try {
            smsService.sendSMS("3522818555", "HelloCCD");
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }
//        transferService.transfer(currentID, userService.findByPhone(friendPhoneNumber).getId(), amount);
        return "index";
    }


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String getIndexPage(@QueryParam("phoneNumber") String phoneNumber, ModelMap modelMap) {
//        String currentID;
//        currentID = userService.findByPhone(phoneNumber).getId();
//        if (currentID == null)
//            currentID = userService.CreateUserByPhone(phoneNumber);
//        modelMap.addAttribute("currentID", currentID);
//        return "chat";
//    }


}