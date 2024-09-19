package com.jingdianjichi.wx.controller;

import com.jingdianjichi.wx.utils.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController

@Slf4j
public class CallBackController {

    private static final String token = "adminXXXXX";

    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }

    /**
     * 回调消息校验
     * 验证消息的确来自微信服务器
     * 详情查看：https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html
     * @return
     */
    @GetMapping("/callback")
    public String callBack(@RequestParam("signature") String signature,
                           @RequestParam("timestamp")String timestamp,
                           @RequestParam("nonce")String nonce,
                           @RequestParam("echostr")String echostr){
        log.info("get验签请求参数：signature:{}，timestamp:{}，nonce:{}，echostr:{}",
                signature,timestamp,nonce,echostr);
        String shaStr = SHA1.getSHA1(token, timestamp, nonce, "");
        if (signature.equals(shaStr)) {
            return echostr;
        }
        return "unknown";
    }

    @PostMapping(value = "/callback",produces = "application/xml;charset=UTF-8")
    public String callBack(
            @RequestBody String requestBody,
            @RequestParam("signature") String signature,
            @RequestParam("timestamp")String timestamp,
            @RequestParam("nonce")String nonce,
            @RequestParam("echostr")String echostr,
            @RequestParam(value = "msg.signature",required = false) String msgSignature){
        log.info("接收到微信的请求：requestBody:{}，signature:{}，timestamp:{}，nonce:{}，echostr:{}",
                requestBody,signature,timestamp,nonce,echostr);
        return "unknown";
    }
}
