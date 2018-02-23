package com.github.plei.modules.job.task;

import org.springframework.stereotype.Component;

/**
 * @author : pleier
 * @date : 2018/2/22
 */
@Component("testTask")
public class TestTask {

    public void test(String param){
        System.out.println("执行有参方法-----参数："+param);
    }

    public void test2(){
        System.out.println("执行无参方法");
    }
}
