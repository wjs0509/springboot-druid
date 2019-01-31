# springboot(1.5.13)-druid&jpa
springboot-druid的配置（配置管理后台的servlet和配置一个web监控的filter）

# application.yml
```
server:
  port: 1111
spring:
  datasource:
    username: root
    password: root
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql:///springboot?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8
    driver-class-name: com.mysql.jdbc.Driver
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT1FROMDUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
```
    
# Druid的配置
```
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

//    配置Druid的监控
//    配置管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        bean.setInitParameters(initParams);
        return bean;
    }

//    2.配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //设置过滤器过滤路径
        bean.addUrlPatterns("/*");
        //忽略过滤的形式
        bean.addInitParameter("exclusions","*.js,*.gif,*.png,*.css,*.ico,/druid/*");
        return bean;
    }
}

```

# 完成后访问 http://localhost:1111/druid 进行查看
