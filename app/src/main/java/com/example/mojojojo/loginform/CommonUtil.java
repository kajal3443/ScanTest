package com.example.mojojojo.loginform;
//package com.silverwing.Vozilo_Care.utils;

import java.util.regex.Pattern;


    public class CommonUtil {

        public final static Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9-]+[_A-Za-z0-9-]*(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        public final static Pattern INVALID_EMAIL_PATTERN = Pattern.compile("^[0-9-]+[_0-9-]*(\\.[_0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        public final static Pattern PASSWORD_VALIDATION = Pattern.compile("[A-Za-z0-9\\#\\'\\*\\+\\-\\:\\=\\@\\^\\_\\`]+$");
        public final static Pattern FIRST_LAST_NAME_PATTERN = Pattern.compile("^[A-Za-z]+[A-Za-z0-9-\\.\\-\\_\\']*$");
        public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

//INVALID_EMAIL_PATTERN.matcher(email).matches() &&

        public static boolean checkEmail(String email) {
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean checkFirstLastName(String name) {
            return FIRST_LAST_NAME_PATTERN.matcher(name).matches();
        }

        public static boolean checkPassword(String password) {
            return PASSWORD_VALIDATION.matcher(password).matches();
        }




        public static boolean isNullString(String string) {
            try {
                if (string.trim().equalsIgnoreCase("null") || string.trim() == null || string.trim().length() < 0 || string.trim().equals("")) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return true;
            }
        }


        public class Login {

        }
    }
