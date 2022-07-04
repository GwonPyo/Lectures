<h1> <strong> View 설정 </strong> </h1>

<h2> <strong> 1. Welcome Page 만들기 </strong> </h2>

Springboot는 <b>'src/main/resources/static'</b> 폴더안에 <b> 'index.html' </b> 파일을 생성하면 해당 파일을 welcome page로 만들어준다. <br>
이때 welcome page란 도메인만 누르고 들어왔을 때 띄워주는 화면을 의미한다. 

index.html에 다음과 같은 내용을 입력해보자.

```(html)
<!DOCTYPE HTML>
<html>
<head>
    <title>Hello_Spring</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    Hello_Spring <br>
    <a href="/hello">hello</a>
</body>
</html>
```

이후 localhost를 다시 실행해보면 다음과 같은 화면이 뜬다.

<h2> <strong> 2. thymeleaf 템플릿 엔진 </strong> </h3>

위에서 한 작업은 단지 우리가 작성한 파일을 웹 서버가 웹 브라우저로 넘겨준다. <br>
이때 템플릿 엔진이라는 것을 사용하게 되면 루프 등 추가적인 기능을 넣어줄 수 있다.

먼저 <b> 'src/main/java' </b> 폴더 안에 controller 패키지를 만들어주자. <br>
그리고 HelloController라는 java class 파일을 생성하자. <br>
이후 해당 파일안에 다음과 같은 내용을 작성해보자.

```(java)
package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello!");
        return "hello";
    }
}
```

* @Controller: sping은 controller파일에 @Controller라고 표시를 해줘야 한다.
* @GetMapping("hello"): localhost8080:hello 요청이 들어오면 아래 함수를 호출한다.
* return "Hello": 이후 ViewResolver가 Hello.html(hello.html)을 찾아 화면을 처리한다.

두 번째로 <b> 'src/main/resources/templates' </b> 폴더 안에 Hello.html 파일을 만들어주자. <br>
그리고 해당 파일안에 다음과 같은 코드를 작성하자.

```(html)
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'안녕하세요! ' + ${data}" >Hello</p>
</body>
</html>
```

* html xmlns:th="http://www.thymeleaf.org": thymeleaf 템플릿 엔진을 선언한 것이다. 이후 해당 템플릿 문법을 사용할 수 있다.
* ${data}: 이전에 model attribute에 추가한 data의 내용이 들어가게 된다. 즉, Hello!가 들어가게 된다.

이후 localhost8080:hello에 접속해보면 다음과 같은 화면을 볼 수 있다.



위 과정들을 정리하면 다음과 같은 방식으로 진행된다.

1. 웹 브라우저에서 localost:8080:hello를 요청한다.
2. Spring boot에 내장된 톰켓 서버에서 해당 요청을 받고 Spring에 요청을 전달한다.
3. 해당 요청에 해당하는 controller(helloController)를 찾아 위에서 작성된 메서드를 실행한다.
4. ViewResolver가 return "hello" 명령에 따라 resources/templates 아래에 있는 hello.html을 찾고 화면을 처리한다.
5. 변환된 hello.html을 웹 브라우저에 전달한다.