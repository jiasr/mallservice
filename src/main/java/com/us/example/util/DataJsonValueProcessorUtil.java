package com.us.example.util;

import net.sf.json.JsonConfig;

import java.util.Date;

public class DataJsonValueProcessorUtil {

    public static JsonConfig getDataJsonValueProcessorConf(){
        JsonConfig cfg = new JsonConfig();
        cfg.setExcludes(new String[]{"handler", "hibernateLazyInitializer"});
        cfg.registerJsonValueProcessor(Date .class, new DateJsonValueProcessor());
        return  cfg;
    }



}
