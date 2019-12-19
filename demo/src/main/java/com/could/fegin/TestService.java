package com.could.fegin;


@MyService("first-police")
public interface TestService{
    @MyMethod("hello")
    public String hello();
    
    @MyMethod("call2")
    public Police call2(Integer id);
}