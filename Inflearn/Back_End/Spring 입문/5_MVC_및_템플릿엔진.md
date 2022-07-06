<h1> <strong> MVC 및 템플릿 엔진 </strong> </h1>

MVC란 Model, View, Controller를 통칭하는 말이다.

* Model: 데이터를 담고 있는 데이터베이스 역할을 한다.
* View: 화면과 관련된 일을 처리한다. 
* Controller: 비지니스 로직 등 서버와 관련된 일들을 처리한다. 

먼저 컨트롤러를 작성해보자.

```(java)
package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello!");
        return "hello";
    }

    @GetMapping("hello_mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello_template";
    }
}
```

이전에 작성한 controller 파일에 이어서 작성한 코드다. <br>
이전에는 hello 버튼 클릭시 동작하는 controller만 작성했다. <br>
이번에는 그 아래에 hello_mvc에 맞는 동작을 하는 controller를 추가했다. <br>

* @RequestParam("name") String name
    - @RequestParam("가져올 데이터 이름") [데이터 타입] [데이터를 담는 변수]
    - 위 방법을 통해 파라미터를 받아올 수 있다.
* 이외의 코드 설명은 "2_View_설정.md" 파일을 참고하자.

그리고 hello_template.html 파일을 "resources/templates" 폴더에 생성하자.

```(html)
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Hello_Template</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'Hello ' + ${name}" >Hello empty</p>
</body>
</html>
```

이후 URL에 localhost:8080/hello_mvc를 입력하면 에러 화면이 발생한다. <br>
hello_mvc 컨트롤러가 <b>매개변수 name</b>을 받아야 하므로 url에 해당 값을 전달해 줘야 에러가 발생하지 않는다. <br>
만약 꼭 받아야 할 필요가 없다면 @RequestParam("name", <b>required=false</b>)라고 선언해주면 된다. <br>
그렇지 않다면 다음과 같이 입력해야 올바른 화면이 출력된다. <br>

* <b>localhost:8080/hello_mvc?name=MVC</b>

![image](https://user-images.githubusercontent.com/85156021/177573371-7d9ad9a1-2888-46f4-9b9c-c8da16b00d0c.png)

처리과정은 이전에 설명했던 것과 동일하다. (2_View_설정.md 참고)
