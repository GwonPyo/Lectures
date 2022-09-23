<h1> <strong> 1. Inheritance </strong> </h1>

다음은 상속 실습 코드다.

```(java)
class Cal{
	public int sum(int v1, int v2) {
		return v1 + v2;
	}
}

class Cal2{
	public int sum(int v1, int v2) {
		return v1 + v2;
	}
	
	public int minus(int v1, int v2) {
		return v1 - v2;
	}
}

class Cal3 extends Cal{
	
}

public class InheritanceApp {
	public static void main(String[] args) {
		Cal c = new Cal();
		System.out.println(c.sum(2, 1));
		
		Cal3 c3 = new Cal3();
		System.out.println(c3.sum(2, 1));
	} 
}
```

위에서 Cal class의 내용을 Cal2 class에 동일하게 복사했다. <br>
이때 Cal의 add 메소드를 변경하면 Cal2에는 적용이 되지 않고 이러한 코드가 많아질수록 관리는 어려워진다. <br>
이때 우리는 상속이라는 개념을 사용할 수 있다. <br>

상속은 **extends 키워드**를 사용하면 부모 클래스를 지정할 수 있다. <br>
이때 상속을 받는 자식 클래스는 부모 클래스의 메소드 및 변수를 가져올 수 있다.

* 단, 자식 클래스에서 부모 클래스를 상속 받을 때 부모는 한 개만 존재해야 한다.

하지만 위처럼 부모 클래스의 내용을 받아오기만 하는 자식 클래스는 굳이 만들 필요가 없다. <br>
즉, 부모 클래스가 할 수 없는 작업을 추가해줘야 한다. <br>
다음은 위 코드를 살짝 수정한 예시 코드다.

```(java)
class Cal{
	public int sum(int v1, int v2) {
		return v1 + v2;
	}
}

class Cal2 extends Cal{
    // override
	public int sum(int v1, int v2) {
        System.out.println("Cal2");
		return v1 + v2;
	}

    public int minus(int v1, int v2) {
		return v1 - v2;
	}
}

public class InheritanceApp {
	public static void main(String[] args) {
		Cal c = new Cal();
		System.out.println(c.sum(2, 1));
		
		Cal2 c2 = new Cal2();
		System.out.println(c2.sum(2, 1));
		System.out.println(c2.minus(2, 1));
	} 
}
```

자손 클래스에서는 기존의 부모 클래스의 메소드를 재정의할 수 있는데 이를 **Override**라고 부른다. <br>
또한 minus 메소드와 같이 추가적인 기능 구현도 가능하다.

이때 Override와 비슷한 용어인 Overloading이라는 개념이 있다. (개념은 전혀 다르다.) <br>
Overloading은 상속과는 관련이 없고 클래스 내에 이름이 동일한 메소드를 여러 개 선언할 수 있는 것을 말한다.

```(java)
class Cal{
	public int sum(int v1, int v2) {
		return v1 + v2;
	}

    public int sum(int v1, int v2, int v3) {
		return v1 + v2 + v3;
	}
}
```
자손 클래스도 동일하게 Overloading이 가능하다.
```(java)
class Cal2 extends Cal{
	public int sum(int v1, int v2, int v3) {
		return v1 + v2 + v3;
	}
	
	public int minus(int v1, int v2) {
		return v1 - v2;
	}
}
```
이 경우 기존 Cal에 있는 sum(int v1, int v2)도 사용 가능하며 새로 정의한 sum 메소드도 사용할 수 있다.