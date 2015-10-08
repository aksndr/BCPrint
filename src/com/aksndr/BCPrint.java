package com.aksndr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Created by Aksndr on 08.10.2015. */
public class BCPrint {


    public BCPrint() {}

    public static Map<String, Object> getSheet(List<String> barCodes){

        if (barCodes.isEmpty()) return failed("Received barCodes list is empty.");

        byte[] value = createSheet(barCodes);


        return succeed(value);
    }

    private static byte[] createSheet(List<String> barCodes) {
       /*
          1 делаем список картинок из штрих кодов
          2 делаем таблицу на 3 столбца и на кол во строк без остатка
          3 прогон€ем таблицу по строкам, €чейкам и в каждую по очереди вставл€ем штрих коды
          4 делаем из файла массив
       */
        return new byte[0];
    }


    private static Map<String, Object> succeed(Object value){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", true);
        result.put("value", value);
        return result;
    }

    private static Map<String, Object> failed(String errMsg){
        Map<String, Object> result = new HashMap<>();
        result.put("ok", false);
        result.put("errMsg", errMsg);
        return result;
    }
}
