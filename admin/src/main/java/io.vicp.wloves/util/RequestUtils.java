package io.vicp.wloves.util;

import io.vicp.wloves.base.BusinessException;
import io.vicp.wloves.base.ExceptionEnum;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/12/31 13:46
 */
public class RequestUtils {

    public static HttpServletRequest getCurrentRequest() {
        return getServletRequestAttributes().getRequest();
    }

    public static HttpServletResponse getCurrentResponse() {
        return getServletRequestAttributes().getResponse();
    }

    private static ServletRequestAttributes getServletRequestAttributes() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return (ServletRequestAttributes) requestAttributes;
        }
        throw new BusinessException(ExceptionEnum.S5000);
    }
}
