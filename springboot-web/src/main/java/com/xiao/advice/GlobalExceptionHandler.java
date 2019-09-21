package com.xiao.advice;

import com.xiao.entity.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ControllerAdvice相当于spring的切面
 * 或者可以自定义继承BasicErrorController
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * 轻求参数格式化
     * @param binder
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder){

    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("attribute",  "The Attribute");
    }

    /**
     * 指定ExceptionHandler异常捕获与处理
     * ResponseStatus：设置返回http状态
     * @param e
     * @return json格式类型
     */
    @ResponseBody
    @ExceptionHandler({CustomizeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> customizeExceptionHandler(CustomizeException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        map.put("time", new Date());
        return map;
    }
}
