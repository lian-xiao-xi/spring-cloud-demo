# 总结

## Zuul 熔断机制

通过定义一个 `FallbackProvider` 类型的 Bean 实现 Zuul 的服务降级。当因为网络不稳定等原因造成网关调用的服务超时或者服务自身异常时，将由我们定义的这个 Bean 来处理并返回我们预设的信息。

Zuul 的超时配置 `zuul.host.connect-timeout-millis`、`zuul.host.socket-timeout-millis`、`ribbon.ReadTimeout`、`ribbon.SocketTimeout`，如果配置的路由方式是 serviceId 的方式，那么 ribbon 开头的生效，如果是 url 的方式，则 zuul.host 开头的生效；熔断超时配置 `hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds`；这其中的任何一个超时都将交给 `FallbackProvider` 类型的 Bean 来处理。