/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.sms_sender;

/**
 *
 * @author Gimhani Uthpala
 */


import hu.ozeki.OzSMSMessage;
import hu.ozeki.OzSmsClient;
import java.io.*;
import java.util.*;

public class OzekiSmsClient extends OzSmsClient{

	public OzekiSmsClient(String host, int port) throws IOException, InterruptedException {
		super(host, port);
	}	

	@Override
	public void doOnMessageAcceptedForDelivery(OzSMSMessage sms) {
		Date now = new Date();
		System.out.println(now.toString() + " Message accepted for delivery. ID: " + sms.messageId);
	}

	@Override
	public void doOnMessageDeliveredToHandset(OzSMSMessage sms) {
		Date now = new Date();
		System.out.println(now.toString() + " Message delivered to handset. ID: " + sms.messageId);
	}

	@Override
	public void doOnMessageDeliveredToNetwork(OzSMSMessage sms) {
		Date now = new Date();
		System.out.println(now.toString() + " Message delivered to network. ID: " + sms.messageId);
	}

	@Override
	public void doOnMessageDeliveryError(OzSMSMessage sms) {
		Date now = new Date();
		System.out.println(now.toString() + " Message could not be delivered. ID: " + sms.messageId + " Error message: " + sms.errorMessage + "\r\n");
	}

	@Override
	public void doOnMessageReceived(OzSMSMessage sms) {
		Date now = new Date();
		System.out.println(now.toString() + " Message received. Sender address: " + sms.sender + " Message text: " + sms.messageData  + " at: "+ sms.receivedDate);
	}

	@Override
	public void doOnClientConnectionError(int errorCode, String errorMessage) {
		Date now = new Date();
		System.out.println(now.toString() + " Message code: " + errorCode + ", Message: " + errorMessage);
	}
	
}
