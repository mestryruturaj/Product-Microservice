package com.product.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayUtils {
    public static <T> List<T> convertArrayToList(T[] array) {
        List<T> ans = new ArrayList<>();
        Collections.addAll(ans, array);
        return ans;
    }
}
