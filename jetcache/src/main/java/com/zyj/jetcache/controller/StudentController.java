package com.zyj.jetcache.controller;

import com.zyj.jetcache.cache.TestStudentCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyj
 */
@RestController
@RequestMapping(value = "/jetcache")
public class StudentController {

    @Autowired
    private TestStudentCache testStudentCache;

    @RequestMapping(value="/getStudent")
    public void get(){
        for (int i = 0; i < 10 ; i++) {
            new Thread(() -> testStudentCache.getStudent()).start();
        }
    }

}
