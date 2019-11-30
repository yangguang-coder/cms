package com.briup.cms.config;

import com.briup.cms.util.JwtTokenUtils;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
   @Autowired
   @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;
    @Autowired
   private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("aplication/json;charset=utf-8");
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
            String token = JwtTokenUtils.createToken(userDetails, false);
            token =JwtTokenUtils.TOKEN_PREFIX + token;
            httpServletResponse.setHeader(JwtTokenUtils.TOKEN_HEADER,token);
            Message<String> success = MessageUtil.success(token);
            httpServletResponse.getWriter().println(objectMapper.writeValueAsString(success));

        } catch (Exception e) {
            Message<Object> message = MessageUtil.error(403, "登录失败");
            httpServletResponse.getWriter().println(objectMapper.writeValueAsString(message));
        }
    }
}
