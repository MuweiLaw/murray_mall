package com.murray.mallclientserver.interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.murray.mallclientserver.base.ResponseBase;
import com.murray.mallclientserver.entity.dto.TokenInfo;
import com.murray.mallclientserver.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    /*
     *@Param [request, response, object]
     *@return boolean
     *@Description: //TODO 在请求处理之前进行调用（Controller方法调用之前）
     *@author Murray Law
     *@date 2019/10/28 15:41
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {

        // 检查用户传递的 token是否合法
        TokenInfo tokenInfo = this.getUserToKen(request);
        if (StringUtils.isBlank(tokenInfo.getAdminId()) && StringUtils.isBlank(tokenInfo.getToken())) {
            // 返回登录
            System.out.println("没有传入对应的身份信息，返回登录");
            return false;
        }
        try {
            String token = redisTemplate.opsForValue().get(tokenInfo.getAdminId());
            if (token != null && token.equals(tokenInfo.getToken())) {
                System.out.println("校验成功");
                return true;
            } else {
                System.out.println("校验失败，返回登录");
                return false;
            }
        } catch (Exception e) {
            System.out.println("校验失败,对呀的信息匹配错误，返回登录");
            return false;
        }

    }

    /*
     *@Param
     *@return
     *@Description: //TODO 在cookie中获取用户传递的token
     *@author Murray Law
     *@date 2019/10/28 15:40
     */
    private TokenInfo getUserToKen(HttpServletRequest request) {

        TokenInfo info = new TokenInfo();
        String adminId = request.getHeader("adminId");
        String token = request.getHeader("token");
        if (StringUtils.isNotBlank(adminId) && StringUtils.isNotBlank(token)) {
            info.setAdminId(adminId);
            info.setToken(token);
        }
        return info;
    }


    @Override
    /*
     *@Param [request, response, object, mv]
     *@return void
     *@Description: //TODO 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *@author Murray Law
     *@date 2019/10/28 15:41
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView mv)
            throws Exception {

    }


    @Override
    /*
     *@Param [request, response, object, ex]
     *@return void
     *@Description: //TODO 25627
     *@author Murray Law
     *@date 2019/10/28 15:44
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex)
            throws Exception {

    }

    /*
     *@Param [response, result]
     *@return void
     *@Description: //TODO 25627
     *@author Murray Law
     *@date 2019/10/28 16:01
     */
    public void returnErrorResponse(HttpServletResponse response, ResponseBase result)
            throws IOException, UnsupportedEncodingException {

        OutputStream out = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
