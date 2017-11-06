package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class Chapter2Controller {
    @RequestMapping("/")
    public String index(ModelMap map) throws IOException {
        // 加入一个属性，用来在模板中读取

        map.addAttribute("host", "http://www.example.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "chapter2";
    }
}