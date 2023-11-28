package my.work.multitenencydatabase.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import my.work.multitenencydatabase.config.TenantContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TenantInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String tenantId = request.getHeader("X-TenantID");
        TenantContextHolder.setContextHolder(tenantId);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        TenantContextHolder.clear();
    }
}
