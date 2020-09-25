package ch.heigvd.amt.stackovergoat.presentation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static com.sun.activation.registries.LogSupport.log;

@WebFilter(filterName = "MagicFilter")
public class MagicFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        log("MagicFilter:doFilter()");
    }

    public void init(FilterConfig config) throws ServletException {
        log("MagicFilter:init()");
    }

}
