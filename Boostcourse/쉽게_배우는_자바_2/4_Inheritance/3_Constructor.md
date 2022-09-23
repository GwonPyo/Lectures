<h1> <strong> 3. Constructor </strong> </h1>

부모 클래스와 자식 클래스에 따로 정의한 생성자가 없다면 기본적으로 부모 클래스의 기본 생성자(super())를 호출한다. <br>
하지만 상속 관계에 있는 클래스의 생성자에 기본 생성자가 아닌 인자가 포함된 생성자를 사용할 때는 주의해야 한다. <br>

만약 부모 생성자에만 인자를 줘야하는 생성자를 정의한 경우 자식 클래스에서 생성자를 명시적으로 만들지 않으면 컴파일 되지 않는다. <br>
왜냐하면 자식 클래스의 생성자가 정의되지 않으면 기본적으로 super()가 사용되는데 부모 클래스는 명시적으로 정의된 생성자가 존재하므로 기본 생성자가 존재하지 않기 때문이다. <br>

아래는 부모와 자식 클래스에 명시적으로 생성자를 정의한 예시다.

```(java)
class Cal{
    int v1, v2;
    Cal(int v1, int v2){
        System.out.println("Cal init!!");
        this.v1 = v1; this.v2 = v2;
    }
    public int sum(){return this.v1+this.v2;}
}
class Cal2 extends Cal{
    Cal2(int v1, int v2) {
        super(v1, v2);      // 해당 실행문이 없으면 에러가 발생한다.
        System.out.println("Cal2 init!!");
    }
    public int minus(){return this.v1-this.v2;}
}
```

추가로 아래의 예시 코드도 살펴보자.

```(java)
class Parent {
    public Parent() {
        System.out.println("Parent");
    }
}
class Child extends Parent {
    public Child() {
        System.out.println("Child");
    }
}

public class InheritanceApp
{
    public static void main(String[] args) {
        Child c = new Child();
    }
}
```

이 경우 Parent와 Child 둘 다 출력된다.