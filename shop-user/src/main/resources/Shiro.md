Springboot集成shiro

1，添加maven依赖
2，自定义Realm 继承AuthorizingRealm 重写  AuthorizationInfo（授权） 和  AuthenticationInfo（认证）

    ShiroAuthorizingRealm 继承 AuthorizingRealm 