# myShop
    
    todo
        
        1，整合shiro + jwt，通过 token 检验权限

#写的什么狗屎玩意

        2，master分支已废，dubbo分支
        3，sso单点登录
        
SpringBoot + Dubbo + Zookeeper
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
