<h1> <strong> 2. Static </strong> </h1>

아래는 static 실습 코드다.

```(java)
class Foo{
	public static String classVar = "I'm class var";
	public String instanceVar = "I'm instance var";
	
	public static void classMethod() {
		System.out.println("----classMethod----");
		System.out.println(classVar);	 	// OK
//		System.out.println(instanceVar); 	// Error
	}
	
	public void instanceMethod() {
		System.out.println("----instanceMethod----");
		System.out.println(classVar);		// OK
		System.out.println(instanceVar);	// OK
	}
}

public class StaticAPP {
	public static void main(String[] args) {
		System.out.println(Foo.classVar); 	// OK
//		System.out.println(Foo.instanceVar);// Error
		Foo.classMethod();					// OK
//		Foo.instanceMethod();				// Error
		
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		
		f1.classVar = "changed by f1";
		System.out.println(Foo.classVar);
		System.out.println(f2.classVar);
		
		f1.instanceVar = "changed by f1";
		System.out.println(f1.instanceVar);
		System.out.println(f2.instanceVar);
		
		f1.classMethod();
		f1.instanceMethod();
	}
}
```

간단히 정리하자면 static을 사용해 선언된 것은 class의 메소드 혹은 변수이고, 그외의 것들을 인스턴스의 메소드 혹은 변수이다. <br>
이때 static이 붙은 메소드와 변수의 특징은 다음과 같다.

* static이 붙은 메소드
    * 해당 메소드는 instance에서도 사용 가능하고, class에서도 사용 가능하다.
    * 메소드 내부에서 class variable은 사용가능하지만 instance variable은 사용불가능하다.
* static이 붙은 변수
    * 해당 변수는 instance에서도 사용 가능하고, class에서도 사용 가능하다.
    * 해당 변수는 instance Method에서도 사용 가능하고, class Method에서도 사용 가능하다.

단, static이 붙은 메소드 혹은 변수를 생성된 인스턴스에서는 값이 들어있는 것이 아니라 class의 해당 변수를 가리킨다. <br>
따라서 만약 인스턴스에서 static variable을 변경한다면 모든 인스턴스와 클래스의 값이 변경된다. <br>
위 내용을 정리하자면 다음과 같다.

* static 변수와 메소드는 해당 클래스로 생성된 모든 인스턴스가 공유하는 자원이다.
* static이 아닌 변수와 메소드는 인스턴스마다 고유의 값을 가진다. 즉, 인스턴스에서 값을 변경해도 다른 인스턴스에 영향을 끼치지 않는다