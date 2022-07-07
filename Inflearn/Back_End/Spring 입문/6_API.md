<h1> <strong> API </strong> </h1>

이전에 작성했던 HelloController 코드에 이어서 아래와 같은 코드를 작성해보자.

```(java)
@GetMapping("hello_api1")
@ResponseBody
public String helloApi1(@RequestParam("name") String name, Model model){
    return "hello "+ name;
}
```

* @ResponseBody: ViewResolver를 사용하지 않고 http 통신 프로토콜의 body 부분에 return값을 직접 넣어준다.

API 방식은 위처럼 문자열이 아니라 데이터를 넣어줘야 할 때 사용한다. <br>
객체를 하나 만들고, 해당 객체를 반환해주는 컨트롤러를 만들어보자.

```(json)
@GetMapping("hello_api2")
@ResponseBody
public Hello helloApi2(@RequestParam("name") String name){
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
}

static class Hello{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
```

* getter, setter 단축키: alt + insert

위와 같이 객체를 반환하게 되면 json 형식으로 데이터를 반환해준다. <br>
위 코드는 다음과 같이 작동하게 된다.

1. 웹 브라우저에서 localhost:8080/hello_api2를 요청한다.
2. 내장 톰켓 서버가 요청을 받고 spring에 요청을 보낸다.
3. 올바른 컨트롤러를 찾는다.
4. @ResponseBody 어노테이션이 붙어있으므로 ViewResolver 대신 <b>HttpMessageConverter</b>가 동작한다. <br> 
단순 문자의 경우 <b>StringHttpMessageConverter</b>가 동작하고, 객체의 경우 <b>MappingJackson2HttpMessageConverter</b>가 동작한다.
    * Jackson은 객체를 json으로 바꿔주는 라이브러리이다.
5. 위 경우 객체이므로 json 형식으로 변경하여 웹 브라우저에 넘겨준다.