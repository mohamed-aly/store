package com.vis.store.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String dateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }



}
