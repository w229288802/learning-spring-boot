#Spring Boot
#### 1、为什么spring boot这么火
1、快速构建REST API，WebSocket，Web，Streaming，Tasks等服务

2、丰富的SQL和NoSQL支持

3、自动化配置(最少化spring前期的配置，并不是全自动)

4、简化第三方软件整合

5、内嵌servlet容器

6、内置跟踪，指标和健康状况

#### 2、spring boot有哪些缺点
1、约定配置分散，不容易知道整合框架的如何配置（查文档，配置元数据）
2、加载复杂，报错难找解决方案（但总是会有办法的）

#### 3、自动化配置原理
1、@Configuration、@Bean替代 xml配置
 
2、元注解/组合注解

3、@Import导入配置类 (ImportSelector.class根据条件导入配置 , ImportDefinationRegistrar.class动态导入bean定义)

4、@Conditional 条件加载




##### 博客
http://blog.didispace.com/