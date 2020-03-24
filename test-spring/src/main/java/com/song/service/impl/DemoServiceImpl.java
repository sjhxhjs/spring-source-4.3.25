package com.song.service.impl;

import com.song.service.IDemoService;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author songjianhua
 * @date 2019-12-24 14:55
 * @description:
 **/
public class DemoServiceImpl implements IDemoService, InitializingBean {

    public void run() {
        System.out.println("run");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("2323232323");
    }
}
