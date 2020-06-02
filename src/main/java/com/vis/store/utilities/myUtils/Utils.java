package com.vis.store.utilities.myUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public Utils() {
    }

    public String dateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }

}
