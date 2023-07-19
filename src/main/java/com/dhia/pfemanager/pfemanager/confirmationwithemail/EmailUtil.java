package com.dhia.pfemanager.pfemanager.confirmationwithemail;

public class EmailUtil {

    public static String getEmailMessage(String name, String host, String token) {
        return "Hello " + name + ",\n\n to reset your password please click the link below. \n\n" +
                getVerificationUrl(host, token) + "\n\nThe support Team";
    }

    public static String getVerificationUrl(String host, String token) {
        return host + "/api/v1/resetPassword/users?token=" + token;
    }

}
