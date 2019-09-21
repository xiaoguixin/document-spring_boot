package com.xiao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 自定义编辑器转换
 */
@RestController
@RequestMapping("/editor")
public class EditorController {

    /**
     * 字符串编辑器
     * localhost:8080/editor?name={"A":"sdfawefa"}
     * 地址不能在浏览器中直接输入
     *
     * @param name 名称
     * @return {&quot;A&quot;:&quot;sdfawefa&quot;}
     */
    @PostMapping
    public String post(String name) {
        return name;
    }

    /**
     * 日期编辑器
     * localhost:8080/editor/date?date=2019-06-05
     *
     * @param date 日期
     * @return "2019-06-04T16:00:00.000+0000"
     */
    @GetMapping(value = "/date")
    public Date date(Date date) {
        return date;
    }
}
