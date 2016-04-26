package com.bhn.adhawk.service;

/**
 * Created by wchen00 on 4/23/16.
 */

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("smsService")
public class SmsService {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC9002b23c466a89d6d12a6cf47d9c09c8";
    public static final String AUTH_TOKEN = "60e1f1caf178b00ea079f85a40233000";
    public static final String ip = "http://10.1.251.149:8080/giftcardApp/invite/";


    public static void main(String[] args) throws TwilioRestException {
        SmsService smsService = new SmsService();
        String phone = "3522818555";
        smsService.sendSMS(phone, "This is Walter");
    }

    public void sendSMS(String reveiver, String msg) throws TwilioRestException {
        String fullMsg = msg + "\n" + " I use Cha Ching send you a gift card.Get it at " + ip + reveiver;
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build the parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", reveiver));
        params.add(new BasicNameValuePair("From", "+13526140067"));
        params.add(new BasicNameValuePair("Body", fullMsg));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
        System.out.print("Send message to :" + reveiver);
        System.out.print("message :" + fullMsg);
        System.out.println(message.getSid());
    }
}