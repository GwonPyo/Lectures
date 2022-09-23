<h1> <strong> 1. Exception </strong> </h1>

숫자를 0으로 나누거나, 배열의 범위를 벗어난 인덱스를 호출하는 등 예상 범위에서 벗어나는 방식으로 프로그램을 동작시킬 때 예상치 못한 결과가 발생할 수 있다. <br>
우리는 이를 예외(Exception)라 부른다. <br>
예외는 아래 코드와 같이 try-catch 구문을 사용해 처리할 수 있다. <br>

```(java)
public class ExceptionApp {
	public static void main(String[] args) {
		System.out.println(1);
		int[] scores = {10, 20, 30};
		try {
			System.out.println(scores[3]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of bounds for length"+scores.length);
		}
		
		try {
			System.out.println(2/0);
		} catch(ArithmeticException e) {
			System.out.println("can't divide");
		}
		System.out.println(3);
	}
}
```

이때 위 방식처럼 코드 한 줄마다 try-cath구문을 쓰지 않고 try-catch 구문의 해당 코드 블럭에 발생할 수 있는 여러 에러들을 처리해줄 수 있다.

```(java)
public class ExceptionApp {
	public static void main(String[] args) {
		System.out.println(1);
		int[] scores = {10, 20, 30};
		try {
			System.out.println(scores[3]);
            System.out.println(2/0);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of bounds for length"+scores.length);
		} catch(ArithmeticException e) {
			System.out.println("can't divide");
		} 
	}
}
```

단, 이 경우 두 예외중 하나라도 발생되게 되면 이후 코드들은 실행되지 않는다.  <br>
따라서 System.out.println(2/0);는 실행되지 않고 해당 예외에 대한 처리는 발생하지 않았다.

<h3> <strong> (1) Exception Class </strong> </h3>

모든 예외들의 부모는 Exception 클래스다. <br>
즉, 자바에서 존재하는 모든 예외들은 Exception 클래스를 상속받는다. <br>
따라서 우리는 위에서 catch 구문을 사용할 때 Exception 클래스를 사용해 포괄적으로 처리할 수 있다. <br>
하지만 그렇게 좋은 방식은 아니다. <br>
사용법은 다음과 같다.

* try {...} catch (Exception e) {...}

<h3> <strong> (2) e </strong> </h3>

우리가 Exception e라고 사용할 때 e는 Exception의 인스턴스다. <br>
이때 e는 발생한 예외에 대한 정보를 담고 있다. <br>

* e.getMessage(): 예외가 발생한 이유를 담고있는 문자열을 반환해준다.
* e.printStackTrace(): 예외 발생시 출력해주는 빨간색 에러문을 출력해준다.

