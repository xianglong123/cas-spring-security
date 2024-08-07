package com.cas.config;

import cn.hutool.extra.spring.SpringUtil;
import com.cas.filter.JwtAuthenticationTokenFilter;
import com.cas.handler.AuthenFailureHandler;
import com.cas.handler.AuthenSuccessHandler;
import com.cas.handler.LogoutSuccessHandler;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author: xianglong[1391086179@qq.com]
 * @date: 下午1:49 2021/4/11
 * @version: V1.0
 * @review:
 */
@Configuration
// EnableGlobalMethodSecurity开启注解配置权限控制
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private AccessDeniedHandler accessDeniedHandler;

    @Resource
    private AuthenSuccessHandler authenSuccessHandler;

    @Resource
    private AuthenFailureHandler authenFailureHandler;

    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;

    // 密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 安全拦截机制(最重要)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //屏蔽CSRF控制，即spring security不再限制CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 对于登录接口，支持匿名访问
                .antMatchers("/user/login").anonymous()
                // 除了上面的所有请求，全部需要鉴权认证
                .anyRequest().authenticated();
        // 把token校验过滤器添加到过滤器链中
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 配置异常处理器
        http.exceptionHandling()
                // 配置认证失败处理器
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        // 登录认证处理
        http.formLogin()
                // 配置认证成功处理器
                .successHandler(authenSuccessHandler)
                // 配置认证失败处理器
                .failureHandler(authenFailureHandler);

        // 登出成功配置
        http.logout()
                .logoutSuccessHandler(logoutSuccessHandler);
        http.logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/sys/out", "DELETE"));
        // 允许跨域
        http.cors();
    }
}
