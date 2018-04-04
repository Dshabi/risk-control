package com.zhenghao.risk.control.common.util;

import java.util.List;

public class ListHelper {

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static <T> T getFirstOrNull(List<T> list) {
        if (isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

}
