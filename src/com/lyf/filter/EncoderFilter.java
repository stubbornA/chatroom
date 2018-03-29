package com.lyf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangjiejie on 2017/11/18.
 */
@WebFilter(filterName = "EncoderFilter",urlPatterns = {"*"},
        initParams = @WebInitParam(name="encoder",value = "utf-8")

)
public class EncoderFilter implements javax.servlet.Filter {
    private Map<String,String> map=new HashMap<>();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(map.get("encoder"));
        resp.setCharacterEncoding(map.get("encoder"));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
            map.put("encoder",config.getInitParameter("encoder"));
    }

}
