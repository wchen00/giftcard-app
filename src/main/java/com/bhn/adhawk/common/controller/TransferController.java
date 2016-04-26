package com.bhn.adhawk.common.controller;

import com.bhn.adhawk.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.QueryParam;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;


    // show update form
    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.POST)
    public
    @ResponseBody
    String transfer(@QueryParam("senderId") String senderId,
                    @QueryParam("receiverId") String receiverId,
                    @QueryParam("amount") String amount,
                    Model model) {

        transferService.transfer(senderId, receiverId, Double.valueOf(amount));

        return "success";

    }


}