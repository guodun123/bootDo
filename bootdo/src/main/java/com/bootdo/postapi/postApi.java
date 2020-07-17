package com.bootdo.postapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value="/", description = "这是我全部的post请求")
@RequestMapping("/rest/rf") //此处的注释的作用是：需要在后续的所有的方法前加/V1
public class postApi {
    //用户登录成功获取到cookie信息，再访问其他接口获取到列表
    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ApiOperation(value="登录接口, 成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value="loginName", required = true) String username,
                        @RequestParam(value="password", required = true) String password,
                        @RequestParam(value="csVersion", required = true) String csVersion,
                        @RequestParam(value="rfVersion", required = true) String rfVersion,
                        @RequestParam(value="wvVersion", required = true) String wvVersion
                        ){
        if(username.equals("rf")&& password.equals("123456")){
            return "恭喜你登录成功";
        }
        return "用户名或者密码错误";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public UpdateDto update(){
        UpdateDto updateDto = new UpdateDto();
        updateDto.setMessage("ces");
        updateDto.setVersionCode(1);
        updateDto.setRequired(1);
        return updateDto;
    }


}
