package io.yaoo.servlet3;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import io.yaoo.config.SpringWebConfig;

/**
 * 配置DispatcherServlet
 */
public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 指定web配置类，启用视图解析、路由映射处理
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    /**
     * 将 DispatcherServlet 映射到 /
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 指定根配置类，驱动中间层和数据层
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

}