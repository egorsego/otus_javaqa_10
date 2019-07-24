package com.otus.utils;

import java.util.Collections;
import java.util.List;

public class Utilities {

    public static boolean areEqualArrays(List<String> arr1, List<String> arr2){
        Collections.sort(arr1);
        Collections.sort(arr2);
        return arr1.equals(arr2);
    }
}
