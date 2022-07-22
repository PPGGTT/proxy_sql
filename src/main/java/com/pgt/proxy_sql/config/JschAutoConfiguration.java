package com.pgt.proxy_sql.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import java.util.Properties;

//@MapperScan("com.pgt.proxy_sql.mapper")
@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(JschProperties.class)
public class JschAutoConfiguration implements InitializingBean, DisposableBean {
    private final JschProperties jschProperties;
    private Session session;

    public JschAutoConfiguration(JschProperties jschProperties) {
        this.jschProperties = jschProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        JSch jsch = new JSch();
        //设置代理本机的主机IP地址
        session = jsch.getSession("root","192.168.10.101", 22);
        session.setPassword("622848");
        Properties properties = new Properties();
        properties.put("StrictHostKeyChecking", "no");
        session.setConfig(properties);
//        System.out.println("Jsch_AutoConfiguration connect to:::host:" + jschProperties.getProxyHost() + ", port : "
//                + jschProperties.getProxyPort() + ", user: " + jschProperties.getProxyUser());
        boolean connected = session.isConnected();
        System.out.println("是否正常连接——————>"+connected);
        session.connect();
//        System.out.println("Jsch_AutoConfiguration:::" + session.getServerVersion());// 打印SSH服务器版本信息
        //设置本地端口号，和访问对象的IP和端口号
//        int assinged_port = session.setPortForwardingL(jschProperties.getLocalPort(), jschProperties.getDestHost(),
//                jschProperties.getDestPort());
//        System.out.println("Jsch_AutoConfiguration:::localhost:" + assinged_port + " -> " + jschProperties.getDestHost()
//                + ":" + jschProperties.getDestPort());
    }

    @Override
    public void destroy() throws Exception {
        if (session != null) {
            session.disconnect();
        }
        System.out.println("Jsch_AutoConfiguration::: destory connection");
    }
}
