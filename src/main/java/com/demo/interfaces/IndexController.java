package com.demo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiansong
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello click house！";
    }
}
