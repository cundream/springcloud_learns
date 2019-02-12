package com.github.cundream.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import sun.security.util.SecurityConstants;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @auther : lc
 * @Date: 2019/1/16 16:59
 * @Description:
 */
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String requestUrl = request.getRequestURL().toString();
        String host = request.getHeader(HttpHeaders.HOST);
        String referer = request.getHeader(HttpHeaders.REFERER);
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);

        log.info("Request:[{} {}], Host:[{}], Referer:[{}], UserAgent:[{}]", request.getMethod(), requestUrl, host, referer, userAgent);

        // userAgent为空，或者不以Mozilla/5.0开头，则说明不合法
        boolean flag = StringUtils.isEmpty(userAgent) || !userAgent.toUpperCase().trim().startsWith("MOZILLA/5.0");

        if (flag) {
            log.warn("This is Crawler Request");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
            ctx.setResponseBody("Bad Request!");
        } else {
            Object accessToken = request.getParameter("accessToken");
            if (accessToken == null) {
                log.warn("access token is empty");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                return null;
            }
        }
        log.info("access token ok");
        return null;
    }
}
