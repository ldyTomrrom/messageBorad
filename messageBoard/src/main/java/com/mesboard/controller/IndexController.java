package com.mesboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自出洞来无敌手 --
 * 2022/6/24
 */
@Controller
public class IndexController {


    @RequestMapping("/registryIndex")
    public String registryIndex(){
        return "registry";
    }
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
 @RequestMapping("/HomePageIndex")
    public String toHomePageIndex(){
        return "HomePage";
    }



}
