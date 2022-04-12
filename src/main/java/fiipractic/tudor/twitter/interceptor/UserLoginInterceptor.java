package fiipractic.tudor.twitter.interceptor;

import fiipractic.tudor.twitter.TwitterApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor implements HandlerInterceptor {
    UrlPathHelper urlPathHelper = new UrlPathHelper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!("/login".equals(urlPathHelper.getLookupPathForRequest(request)))
                && !("/users".equals(urlPathHelper.getLookupPathForRequest(request)))
                && !("/register".equals(urlPathHelper.getLookupPathForRequest(request)))
                && TwitterApplication.loggedUser==null){
            String encodedRedirectURL = response.encodeRedirectURL(request.getContextPath() + "/login");
            response.setStatus(HttpStatus.TEMPORARY_REDIRECT.value());
            response.setHeader("Location", encodedRedirectURL);

            return false;
        }
        else
        {
            return true;
        }
    }
}
