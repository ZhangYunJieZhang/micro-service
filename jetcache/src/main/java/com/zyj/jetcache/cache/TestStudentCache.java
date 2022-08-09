package com.zyj.jetcache.cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.CacheGetResult;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.zyj.jetcache.bean.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zyj
 * 缓存类
 */
@Component
public class TestStudentCache {

    private Logger logger = LoggerFactory.getLogger(TestStudentCache.class);

    private final String STUDENT_PREFIX = "student_cache_name";

    /**
     * 通过@CreateCache注解创建一个二级（内存 + 远程）缓存实例，默认超时时间是60秒，内存中的元素个数限制在50个
     */
    @CreateCache(name = STUDENT_PREFIX, expire = 60, cacheType = CacheType.BOTH, localLimit = 50)
    private Cache<String, Student> studentCache;

    public Student getStudent() {
        Student student ;
        CacheGetResult<Student> result = studentCache.GET("10000");
        if(result.isSuccess()){
            logger.info("获取成功");
            student = result.getValue();
            return student;
        }
        // 先获取锁，串行操作，这里要考虑redis分布式缓存的问题
        logger.info("获取失败，添加缓存");
        student = new Student(100, "张三", 1);
        studentCache.put("10000", student);
        return student;
    }

}
