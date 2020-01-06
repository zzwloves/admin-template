package io.vicp.wloves.filter;

import com.alibaba.fastjson.JSON;
import io.vicp.wloves.base.BaseConstant;
import io.vicp.wloves.base.ExceptionEnum;
import io.vicp.wloves.base.ResponseResult;
import io.vicp.wloves.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2020/1/3 16:42
 */
@Order(2)
@Component
@WebFilter(filterName = "tokenFilter", urlPatterns = "/**", asyncSupported = true)
public class TokenFilter implements Filter {

    private static final List<String> WHITE_LIST = Arrays.asList("/", "/sysUser/login");

    @Autowired
    private SysUserService sysUserService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            String path = ((HttpServletRequest) servletRequest).getServletPath();
            if (!WHITE_LIST.contains(path)) {
                String token = ((HttpServletRequest) servletRequest).getHeader(BaseConstant.HEADER_TOKEN);
                if (StringUtils.isEmpty(token) || Objects.isNull(sysUserService.getInfoByToken(token))) {
                    ResponseResult responseResult = new ResponseResult(ExceptionEnum.U4000.getCode(), ExceptionEnum.U4000.getMsg());
                    HttpServletResponse response = (HttpServletResponse) servletResponse;
                    response.setStatus(200);
                    response.getOutputStream().write(JSON.toJSONBytes(responseResult));
                    return;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}
}
