package com.chen.lvyou.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/22 13:20
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Bean
    // 方法的返回值是bean容器的实例
    public LocaleResolver localeResolver() {
        // LocaleResolver是一个父接口，方法的返回值只能定成这个名字，以前写springMVC.xml时id必须写localeResolver是一个道理,如果改成别的名字，DispacherServlet就没办法加载它
        // CookieLocalResolver与SessionLocaleResolver类似
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        // 设置默认的语言种类
        localeResolver.setDefaultLocale(Locale.CHINA);
        // 失效
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor interceptor() { // 方法名不重要，但方法的返回值是不能随意取
        return new LocaleChangeInterceptor();
    }

    /**
     * 继承了WebMvcConfigurationSupport，所以要重写两个方法
     * 除了有拦截器实例，还要把实例加载到拦截器栈里面去
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor());
    }

    /**
     * 因为配置了拦截器，所以springMVC的dispatcherServlet就会启动，原来静态资源加载就会出问题了
     *
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 处理静态资源访问
        // 根目录下的任何静态资源被请求时，都到/webapp/WEB-INF/views/目录下去找静态资源
        registry.addResourceHandler("/**").addResourceLocations("classpath:/webapp/WEB-INF/views/");
        // registry要加载父类的registry里面
        super.addResourceHandlers(registry);

    }
}
