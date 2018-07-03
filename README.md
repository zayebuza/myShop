# myShop  
目前shop-dubbo分支在更新dubbo版本，主分支问题很大。。。。
    todo
        
        1，整合shiro + jwt，通过 token 检验权限
        目前使用的是，用户登录之后使用UUID生成一个token，然后将token当做key，用户信息当做value，之后所有请求到controller的都把token当做参数，然后通过token获取到用户的uid。这样存在的缺陷很大，1，存在redis的key是不合用户信息有任何关联的。2，登录一次就会生成一个token，不能保证有效token唯一，之后需要完善。

#写的什么狗屎玩意

        
## SpringBoot + Dubbo + Zookeeper
    Dubbo版本：使用Dubbo Spring Boot ，阿里开源的基于SpringBoot的Dubbo版本， https://github.com/apache/incubator-dubbo-spring-boot-project
    具体集成方式可参照官方文档，网上有一些相应的教程，不多Dubbo近期更新较大，有些细节都能在官方更新中发现，所以建议参照官方文档集成。
   
    Registry：服务注册，采取Zookeeper 作为我们的注册中心
    Provider：服务提供者（生产者），提供具体的服务实现
        shop-user
        shop-order
        shop-product
        以上三个是服务提供者，
    Consumer：消费者，从注册中心中订阅服务
        shop-web
        
    shop-api

    Dubbo-admin
        https://github.com/apache/incubator-dubbo-ops
        基于官方文档安装失败，没找到什么原因。可以下载最新代码，使用idea直接运行 dubbo-admin，可以直观的看到，注册到zk的服务。
        

   ## Jenkins 2.0
    Jenkisn 2.0  Pipeline构建项目，达到提交代码之后出发构建，执行单元测试，jmeter脚本，统计代码覆盖率，接口覆盖率等，之发送邮件通知
    Jenkinsfile文件的编写，熟悉Groovy语言
    
   ## 完善单元测试
    Junit
   
   ## Jmeter脚本
    执行脚本
   
   
   ## Shell脚本  一键部署
    一键部署
   
   
