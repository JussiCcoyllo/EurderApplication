package com.switchfully.eurder.controller;

import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping(path = "/test")
    public class TestController {

        @GetMapping
        public String test() {
            return "test";
        }
    }

