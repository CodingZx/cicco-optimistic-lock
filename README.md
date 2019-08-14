# OptimisticLock

基于Spring AOP实现乐观锁重试机制

### 使用方式

- 使用@Retry注解
> value: 重试次数 默认3次 <br>
> forException: 针对异常 默认lol.cicco.optimisticlock.exception.OptimisticLockException <br>
```java
    @Retry(value = 5, forException = Exception.class)
    public Object retryMethod() {
        // do something...
    }
```
> 例如以下代码:
> ```
>   @Retry(value = 5, forException = NullPointException.class)
>   public Object retryMethod() {
>       // do something...
>   }
> ```
>   将只针对NullPointException及其子类异常进行重试, 重试次数为5 <br> 
>   若方法内部抛出其他类型异常, 将不会重试



#### 示例详见[单元测试](https://github.com/CodingZx/cicco-optimistic-lock/blob/master/src/test/java/lol/cicco/service/RetryService.java)
