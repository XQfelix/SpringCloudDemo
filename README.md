# SpringCloudDemo
包含了SpringCloud 的注册中心  以及  服务端  以及Fegin客户端的调用

# 注册中心
fist-eurekaserver

# 服务的提供者
fist-police-server

# 服务调用方
fist-person-client


`上面便是微服务调用配套的三个组件`

>然而有些时候, 有一些老的工程呢也需要调用微服务, 但是主要业务不想改动, 那么你或许需要看下下面的例子

# 适用于非SpringCloud服务(老项目),自定义实现的一个Fegin客户端, 进行微服务的调用
cuntomFeginClient 


# 改造原旧项目的启动类, 换成SpringBoot的启动方式, 但是禁用Web功能, 这样便可以使用FeginClient调用了
springNoWebFeginClient
