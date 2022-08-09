package com.zyj.oauthserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 配置我们httpBasic 登陆账号和密码
 * security配置，底层也是通过过滤器链实现
 */
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 2.0以上版本强制要求要加密，可以通过注入NoOpPasswordEncoder这个bean变成不加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置认证用户信息和权限
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //实际应用都是多用户，应该查询数据库(实现userDetailService接口的方法，然后传入实现类即可)，然后循环调用以下方法
        auth.
                inMemoryAuthentication()
                .withUser("mayikt")
                .password(passwordEncoder().encode("123456"))
                .authorities("/*");//该用户有全部url的权限

        auth.
                inMemoryAuthentication()
                .withUser("mayikt2")
                .password(passwordEncoder().encode("123456"))
                .authorities("addOreder","deleteOrder");//该用户只有名叫addOreder的权限，多个逗号隔开


    }

    /**
     * 配置拦截的请求资源
     *
     * 如果嫌弃自带的登录页面过丑，可以自己定义页面
     * 首先.formLogin().loginPage("/login");指定页面
     * 然后放行登录请求.antMatchers("/login").permitAll();
     * 最后表单中的用户框密码框的name只能username和password，不能其他名字，且表单提交url必须/login
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/addOreder").hasAnyAuthority("addOreder")也可以配置只拦截某一个
                //.hasAnyAuthority("addOreder")资源别名
                .anyRequest().authenticated() //所有请求都需要通过认证
                .and()
                .httpBasic() //and之后选择认证模式为httpBasic（还有一种为formlogin）,此方式登录页有点丑
                .and()
                .csrf().disable(); //关跨域保护
    }

    /**
     * 验证成功或者失败的结果可以通过实现成功和失败的接口拿到，参数有req和res可以随意操作
     * HttpSecurity要在这里面添加进去.formLogin().loginPage("/login").succ。。。。
     */
}