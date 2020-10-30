package com.pcloud;

import com.pcloud.sys.common.core.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 牧云开发框架的启动类
 *
 * @author huotengfei
 */
@Slf4j
@SpringBootApplication
public class PCloudFrameRun {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(PCloudFrameRun.class, args);
        Environment env = app.getEnvironment();
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new CommonException("获取本地IP失败，请联系管理员");
        }
        // 系统ip及端口号
        log.info("\n----------------------------------------------------------\n\t"
                        + "名称:\t'{}' is running! Access URLs:\n\t"
                        + "版本:\t'{}'\n\t"
                        + "作者:\t'{}'\n\t"
                        + "本地:\t http://localhost:{}\n\t"
                        + "外部:\t http://{}:{}\n\t"
                        + "环境:\t {}\n----------------------------------------------------------",
                env.getProperty("pcloud.project.name"),
                env.getProperty("pcloud.project.version"),
                env.getProperty("pcloud.project.author"),
                env.getProperty("server.port"),
                localHost.getHostAddress(),
                env.getProperty("server.port"),
                env.getActiveProfiles());
    }
}
