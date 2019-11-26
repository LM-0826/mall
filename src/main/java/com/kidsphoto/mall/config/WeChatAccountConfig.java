package com.kidsphoto.mall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 李明
 * @create 2019-11-25 18:24
 */
@lombok.Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatAccountConfig {


}
