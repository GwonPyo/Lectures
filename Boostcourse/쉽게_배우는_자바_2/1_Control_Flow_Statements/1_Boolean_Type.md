<h1> <strong> 1. Boolean Type </strong> </h1>

아래는 수업에서 진행한 실습 코드다.

```(java)
public class BooleanApp {
	public static void main(String[] args) {
		System.out.println("One"); 	// String
		System.out.println(1); 		// Integer

		System.out.println(true);	// Boolean type 1
		System.out.println(false);	// Boolean type 2
		
		String foo = "Hello World";
		// String true = "Hello World"; reserved word
		
		System.out.println(foo.contains("World"));
		System.out.println(foo.contains("world"));	
	}
}
```

우리는 boolean data type을 통해 참과 거짓을 표현할 수 있다. <br>
boolean type은 true와 false 두 가지만 존재하며 이 둘은 예약어로 다른 변수의 이름으로는 사용될 수 없다. <br>

* (문자열 변수).contains(문자열) - 문자열 변수에 원하는 문자 혹은 문자열이 들어있는지 확인할 수 있다.