package com.example.laba1_kpp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("value1", "");
        model.addAttribute("value2", "");
        return "home_page";
    }

    @GetMapping("/edit")
    public String edithomeView(@RequestParam(required = false) String value1,
                               @RequestParam(required = false) String value2,
                                       Model model){
        System.out.println("First value" + value1);
        System.out.println("Second value" + value2);

        if(value1 != "") {
            model.addAttribute("value1", value1);
            model.addAttribute("value2", reverseString(value1));
            return "home_page";
        }
        model.addAttribute("value2", value2);
        model.addAttribute("value1", reverseString(value2));
        return "home_page";
    }

    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result = result + array[i];
        }
        return result;
    }
}
