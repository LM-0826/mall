package com.kidsphoto.mall.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by tracywindy on 2016-12-4.
 */
public class ExceptionUtil {
    public static String getExceptionInfo(Throwable ex) {
        ByteArrayOutputStream bout  = null;
        PrintStream pout = null;
        try {
            bout  = new ByteArrayOutputStream();
            pout = new PrintStream(bout);
            ex.printStackTrace(pout);
            return  new String(bout.toByteArray());
        }catch(Exception e){
            return null;
        }finally{
            try{
                if(null != pout){
                    pout.close();
                    pout = null;
                }
            }catch(Exception e){}
            try{
                if(null != bout){
                    bout.close();
                    bout = null;
                }
            }catch(Exception e){}
        }
    }
}
