package com.us.example.controller;

import com.us.example.bean.GoodsCatalog;
import com.us.example.serviceImpl.GoodsCatalogService;
import com.us.example.util.CommonUtil;
import com.us.example.util.DataJsonValueProcessorUtil;
import com.us.example.util.DateJsonValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping(value = "/goodscatalog")
public class GoodsCatalogController {


    private static final Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private GoodsCatalogService goodsCatalogService;

    private static Log log = LogFactory.getLog(UserController.class);


    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String addUser(@RequestBody GoodsCatalog goodscatalog) {

        GoodsCatalog goodsCatalog = new GoodsCatalog();
        goodsCatalog.setName(goodscatalog.getName());
        goodsCatalog.setLevel(goodscatalog.getLevel());
        goodsCatalog.setParantId(goodscatalog.getParantId());
        goodsCatalog.setThumbnail(goodscatalog.getThumbnail());
        goodsCatalogService.saveCatalog(goodsCatalog);

        JSONObject jsonObject = JSONObject.fromObject(goodsCatalog, DataJsonValueProcessorUtil.getDataJsonValueProcessorConf());
        log.info(jsonObject.toString());

        return jsonObject.toString();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public String listUser(HttpServletRequest request) {
        Map<String, Object> map = CommonUtil.getParameterMap(request);
        List<GoodsCatalog> list = goodsCatalogService.getAllCatalog();


//        for(GoodsCatalog g:list){
//            g.setCreateTime(null);
//
//           if(g.getParantId().equals("0")){
//               g.setChildren(getChildCata(g.getId(),list));
//           }
//        }
//
//
//        for(GoodsCatalog g:list){
//            for(GoodsCatalog gc:g.getChildren()){
//                gc.setChildren(getChildCata(gc.getId(),gc.getChildren()));
//            }
//        }



        JSONArray jatmp =  JSONArray.fromObject(list, DataJsonValueProcessorUtil.getDataJsonValueProcessorConf());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",jatmp);
        log.info(jsonObject.toString());
        return jsonObject.toString();
    }


    private  List<GoodsCatalog> getChildCata(String cataid,List<GoodsCatalog> list){
        List<GoodsCatalog> childlist = new ArrayList<GoodsCatalog>();
        for(GoodsCatalog g:list){
            if(g.getParantId().equals(cataid)){
                childlist.add(g);
            }
        }
        return childlist;
    }


}
