package com.legend.hello;

/**
 * Created by dell-pc on 2017/8/31.
 */
import com.alibaba.fastjson.JSONObject;
import com.legend.service.SysDictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
//@EnableAutoConfiguration
public class SampleController {

    private final static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SysDictionaryService sysDictionaryService;
//
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
//        return "Hello World";
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String home2(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
//        return mav;
        return "Hello World";
    }
    @RequestMapping(value = "/hello2")
    @ResponseBody
    public String getDictionary(){
        logger.info("============================");
        return JSONObject.toJSON(sysDictionaryService.getDictionartLists()).toString();
    }

    public static void main(String[] args) {
       System.out.println(Integer.toHexString(80));
    }
}
