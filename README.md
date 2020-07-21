# 总结

## Zuul 熔断机制

通过定义一个 `FallbackProvider` 类型的 Bean 实现 Zuul 的服务降级。当因为网络不稳定等原因造成网关调用的服务超时或者服务自身异常时，将由我们定义的这个 Bean 来处理并返回我们预设的信息。

Zuul 的超时配置 `zuul.host.connect-timeout-millis`、`zuul.host.socket-timeout-millis`、`ribbon.ReadTimeout`、`ribbon.SocketTimeout`，如果配置的路由方式是 serviceId 的方式，那么 ribbon 开头的生效，如果是 url 的方式，则 zuul.host 开头的生效；熔断超时配置 `hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds`；这其中的任何一个超时都将交给 `FallbackProvider` 类型的 Bean 来处理。

## 项目功能及测试说明

### 消费方功能

`openfeign` 组件包含 `Hystrix` ，所以也具有服务容错功能。

对外 Api：

- [api_a: http://localhost:8801/consumer/user/one/2](http://localhost:8801/consumer/user/one/2) 
- [api_b: http://localhost:8801/consumer/user/one/1](http://localhost:8801/consumer/user/one/1)

其中 api_a 会连接超时，触发消费方容错框架 Hystrix 的服务降级，api_b 可以正常访问。三五秒内连续请求20次 api_a，使消费方服务触发熔断，此时消费方的其他 api 会进行服务降级，此时访问 api_b 将无法得到预期的响应。

### 网关功能

`Zuul` 组件包含 `Hystrix` ，所以也具有服务容错功能。

对外 Api：

- [api_1:  http://localhost:10010/api/consumer/consumer/user/one/1 ]( http://localhost:10010/api/consumer/consumer/user/one/1 )
- [api_2:  http://localhost:10010/api/consumer/consumer/user/one/2](http://localhost:10010/api/consumer/consumer/user/one/2)

其中 api_2 将触发 Zuul 的服务降级功能，创建一个实现 FallbackProvider 接口的 Bean ，在其内部编写具体的服务降级功能逻辑；api_1 可以正常访问。三五秒内连续请求20次 api_2，将网关服务触发熔断，此时网关服务的其他 api 会进行服务降级，此时访问 api_1 将无法得到预期的响应。