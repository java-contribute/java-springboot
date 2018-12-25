package javacontribute.javaspringboot.Filter;

import com.alibaba.fastjson.JSON;
import javacontribute.javaspringboot.dao.ParameterRequestWrapper;
import javacontribute.javaspringboot.entity.FilterEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author: Lijie
 * @Date: 2018/12/25 10:03
 */
public class ParameterFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParameterFilter.class);

    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;

        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper((HttpServletRequest)servletRequest);

        FilterEntity filterEntity = new FilterEntity();
        filterEntity.setId(1);
        filterEntity.setPhoneNum("123456789");
        String str = JSON.toJSONString(filterEntity);
        LOGGER.info("str:{}", str);
        requestWrapper.addParameter("filterEntity", str);

        filterChain.doFilter(requestWrapper, httpResponse);
//        filterChain.doFilter(httpRequest, httpResponse);
    }


    /**
     * 是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
