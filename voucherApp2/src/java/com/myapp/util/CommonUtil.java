/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *
 * @author azmeerazehar
 */
public class CommonUtil {
    public static String nullToString(String str) {
//        return (str == null || str.matches("\\\\")) ? "":str.trim();
        if (str == null) {
            return "";
        } else if (str.equalsIgnoreCase("null")) {
            return "";
        } else if (str.trim().matches("\\\\")) {
            str = str.replaceAll("\\\\", "");
            return str.trim();
        } else {
            return str.trim();
        }
    }
    
    public static String convertException(Exception ex) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sw.flush();
            pw.flush();
        }
        return sw.toString();
    }
}
