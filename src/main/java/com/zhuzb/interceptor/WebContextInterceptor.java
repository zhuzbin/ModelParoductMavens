package com.zhuzb.interceptor;

import com.zhuzb.util.UtilValidate;
import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebContextInterceptor implements HandlerInterceptor {

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

    private final static String login_url = "/tree/login.shtml";

    private final static String revision = "3.2";

    private static Logger logger = Logger.getLogger(WebContextInterceptor.class);

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)throws Exception {
        long endTime = System.currentTimeMillis();// 2、结束时间
        long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
        long consumeTime = endTime - beginTime;
        if(consumeTime > 500) {
            //此处认为处理时间超过500毫秒的请求为慢请求
            logger.info(String.format("请求------------------->>>>>> %s用时%d毫秒", request.getRequestURI(), consumeTime));
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView)throws Exception {

    }
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        logger.info("请求------------------->>>>>>"+request.getServletPath());
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        startTimeThreadLocal.set(System.currentTimeMillis());
        String servletPath = request.getServletPath();
        if(UtilValidate.isEmpty(request.getSession().getAttribute("userId"))) {
            //重定向到登录页面
            //request.setAttribute("servletPath",servletPath);
            //request.getRequestDispatcher(login_url).forward(request,response);
            response.sendRedirect(request.getContextPath() + login_url+"?servletPath="+servletPath);
            return false;
        }
        return true;
    }
}
