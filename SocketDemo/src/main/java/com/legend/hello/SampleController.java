package com.legend.hello;

/**
 * Created by dell-pc on 2017/8/31.
 */
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
//@EnableAutoConfiguration
public class SampleController {
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
}
