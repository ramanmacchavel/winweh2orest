package com.hibernate.ws;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Path("/Otp")
public class OTPSender {
    @GET
    @Path("{mobileNumber}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendOTP(@PathParam("mobileNumber") String mobileNumber) {
    	
    	
    	UserData user = new UserData();
    	user.setMobileNumber(mobileNumber);
    	user.setOtp("3857");
    	//user.setUserId(1);
    	user.setUserName("Raman M");
    	
    	Configuration conf = new Configuration().configure().addAnnotatedClass(UserData.class);
    	SessionFactory sf = conf.buildSessionFactory();
    	Session session = sf.openSession();
    	session.save(user);
    	Transaction txn = session.beginTransaction();
    	txn.commit();
    	
    	return "This is a Test " + mobileNumber;
       
       
       
    }
}
