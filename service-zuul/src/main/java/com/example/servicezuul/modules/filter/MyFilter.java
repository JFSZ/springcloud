package com.example.servicezuul.modules.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author: chenxue
 * @create: 2020-01-19 17:33
 **/
@Component
@Slf4j
public class MyFilter extends ZuulFilter {
    /**
     * @Description: filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @param
     * @Author: chenxue
     * @Date: 2020/1/19  17:38
     */
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    //目前 模拟 登陆权限
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter("token");
        log.info("【Filter 模块】 -- token = " + token);
        if(StringUtils.isBlank(token)){
            log.info("【Filter 模块】 -- token 为空! ");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                //解决中文乱码问题
                requestContext.getResponse().setContentType("text/html;charset=UTF-8");
                requestContext.getResponse().getWriter().write("token 不可为空!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("【Filter 模块】 -- ok");
        return null;
    }
}
