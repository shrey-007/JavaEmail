package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

//if it is giving error then watch this video https://youtu.be/aP4QjemS8nc?si=zllsze5sRcgX1579
public class Main {
    private static void sendEmail(String message,String subject,String to,String from){
        //variable for gmail
        //to is server se mail bhejege
        String host="smtp.gmail.com";

        //get the system properties
        Properties properties=System.getProperties();

        //setting important information to properties object
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //step1=get the session object
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shreyyerhs07@gmail.com","rqch lwmt xfdj bizv");
            }
        });

        //step2=compose the message
        session.setDebug(true);

        MimeMessage mimeMessage=new MimeMessage(session);
        try{
            //jo bhej rha hai vo set kro
            mimeMessage.setFrom(from);

            //jisko bhejna hai vo set kro
            mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            //adding subject
            mimeMessage.setSubject(subject);

            //adding content
            mimeMessage.setText(message);
            //you can also send files, watch the end of video https://youtu.be/l0J-Edn76js?si=4i4sfblydxqIOV9f

            //step3= send the message using transport class
            Transport.send(mimeMessage);

            System.out.println("send successfully");
        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        //general information
        String message="Hello Manthan";
        String subject="Test";
        String to="22bcs154@iiitdmj.ac.in";
        String from="shreyyerhs07@gmail.com";

        sendEmail(message,subject,to,from);

    }
}