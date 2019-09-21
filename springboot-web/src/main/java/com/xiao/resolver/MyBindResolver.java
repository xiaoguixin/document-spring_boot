package com.xiao.resolver;

import org.springframework.validation.MessageCodesResolver;

public class MyBindResolver implements MessageCodesResolver {
    @Override
    public String[] resolveMessageCodes(String s, String s1) {
        System.out.println("s："+s+",s1:"+s1);
        return new String[0];
    }

    @Override
    public String[] resolveMessageCodes(String s, String s1, String s2, Class<?> aClass) {
        System.out.println("s："+s+",s1:"+s1+",s2:"+s2+",aClass"+aClass);
        return new String[0];
    }
}
