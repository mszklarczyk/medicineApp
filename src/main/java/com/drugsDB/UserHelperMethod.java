package com.drugsDB;

import java.lang.reflect.Array;

public class UserHelperMethod {
    public static String parseDrugSubstance(String a) {
        StringBuilder sb= new StringBuilder();
        String[] arr = a.split(", ");
        sb.append("\"");
        for (int i =0;i<arr.length;i++){
            sb.append(arr[i]);
            if (i!=arr.length-1) sb.append("\", \"");
        }
        sb.append("\"");
        return sb.toString();
    }



}
