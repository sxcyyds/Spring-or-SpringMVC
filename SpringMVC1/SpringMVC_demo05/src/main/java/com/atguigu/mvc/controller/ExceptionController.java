package com.atguigu.mvc.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public  String test1(Exception exception,Model model){
        model.addAttribute("ex",exception);
        return "erro";
    }

}
