<h1> <strong> Java의 동작 원리 </strong> </h1>

<h3> <strong> HelloWorld </strong> </h3>

다음은 "Hello world!!"를 출력하는 Java 프로그램의 코드다.

```(java)
public class HelloWorldApp{
    public static void main(string [] args){
        System.out.println("Hello world!!");
    }
}
```
이때 우리가 작성한 것을 source, code라고 부른다. <br>
그리고 이것에 대한 결과를 application(app), program이라고 부른다.

<h3> <strong> 동작 원리 </strong> </h3>

Java의 동작 원리는 다음과 같다.

1. Java Source Code(.java)를 작성한다.
2. 컴파일을 통해 Java Application(.class)를 생성한다. <br>
    => Java Source Code는 컴퓨터가 이해할 수 없기 때문에 해당 과정을 거쳐야 한다. 
3. Java Virtual Machine이 .class 파일을 읽고 컴퓨터를 동작시킨다.

eclipse에서는 source code 저장시 자동으로 .class 파일을 생성하고, run 버튼을 누르면 Java Virtual Machine에게 해당 파일들을 넘겨준다. 

