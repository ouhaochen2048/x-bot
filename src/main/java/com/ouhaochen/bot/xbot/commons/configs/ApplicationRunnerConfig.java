package com.ouhaochen.bot.xbot.commons.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationRunnerConfig implements ApplicationRunner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private int serverPort;

    @Value("${shiro.ws.server.url}")
    private String contextPath;

    @Value("${spring.profiles.active}")
    private List<String> profiles;

    @Override
    public void run(ApplicationArguments args) {
        log.info("""
                
                ----------------------------------------------------------
                Application '{}' is running!
                WS Server:    ws://localhost:{}{}
                Profile(s): {}
                ----------------------------------------------------------
                """, appName, serverPort, contextPath, profiles);
    }
}