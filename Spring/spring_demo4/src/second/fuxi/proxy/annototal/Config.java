package second.fuxi.proxy.annototal;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages ={"second.fuxi.proxy.annototal"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
