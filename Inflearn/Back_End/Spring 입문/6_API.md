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

이제 해당 url로 접속해보면 다음과 같은 화면이 뜬다.

![image](https://user-images.githubusercontent.com/85156021/177677126-768b428f-67eb-4fdb-9b15-b5b1c0dab4be.png)

소스 코드를 보면 이전까지 작성했던 html 형식이 아니라 <b>문자열 자체가 들어가 있는 것을 확인할 수 있다</b>.

![image](https://user-images.githubusercontent.com/85156021/177677572-a658d73f-24d8-4b9f-82ed-f3dee9ed1c67.png)<br>
API 방식은 위처럼 문자열이 아니라 <b>데이터를 넣어줘야 할 때 사용</b>한다. <br>
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

위와 같이 객체를 반환하게 되면 <b>json 형식</b>으로 데이터를 반환해준다. <br>

![image](https://user-images.githubusercontent.com/85156021/177677378-e5d365aa-1e02-4b8a-94c1-c77bda6fe633.png)

소스 역시 json 형식으로 구성된다.

![image](https://user-images.githubusercontent.com/85156021/177677488-0d36b80e-9473-4d61-a6bc-c7494e1307a7.png)

위 코드는 다음과 같이 작동하게 된다.

1. 웹 브라우저에서 localhost:8080/hello_api2를 요청한다.
2. 내장 톰켓 서버가 요청을 받고 spring에 요청을 보낸다.
3. 컨트롤러를 찾는다.
4. @ResponseBody 어노테이션이 붙어있으므로 ViewResolver 대신 <b>HttpMessageConverter</b>가 동작한다. <br> 
단순 문자의 경우 <b>StringHttpMessageConverter</b>가 동작하고, 객체의 경우 <b>MappingJackson2HttpMessageConverter</b>가 동작한다.
    * Jackson은 객체를 json으로 바꿔주는 라이브러리이다.
5. 위 경우 객체이므로 json 형식으로 변경하여 웹 브라우저에 넘겨준다.
