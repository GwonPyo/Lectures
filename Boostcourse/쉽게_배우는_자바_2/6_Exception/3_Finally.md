<h1> <strong> 3. Finally </strong> </h1>

<h3> <strong> (1) Finally </strong> </h3>

try-catch 문은 예외 발생시 예외 발생 이후의 코드는 실행하지 않는다. <br>
이때 finally 문을 사용할 수 있는데 finally 문은 try 문에서 예외가 발생했든 하지 않았든 무조건 실행된다. <br>
아래는 IOException 처리 예시 코드다.

```(java)
import java.io.FileWriter;
import java.io.IOException;

public class CheckedExceptionApp {
	public static void main(String[] args) {
		FileWriter f = null; 
		try {
			f = new FileWriter("data.txt");
			f.write("Hello");
			// close를 하기 전에 예외가 발생한다면 close가 실행되지 않음
			// f.close();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if (f != null) {
				try {
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}
	}
}
```

* FileWriter를 밖으로 빼지 않으면 finally 문에서 에러가 발생한다.
 - try 문에서 선언하면 중괄호 내에서만 존재하는 인스턴스가 되므로 밖으로 빼줘야 한다.
 * f를 처음에 null로 지정해준 이유는 처음에 f에 어떠한 값도 지정하지 않으면 finally 내부에서 f가 초기화되지 않아 문제가 될 수 있으므로 경고를 주기 때문이다.

<h3> <strong> (2) try-with-resource </strong> </h3>

위의 예시코드는 resource를 반환하는데 코드가 좀 긴 느낌이 있다. <br>
Java SE 7부터는 try-with-resource문을 사용해 자원 관리를 더 단순하게 진행할 수 있다. <br>
단, 클래스가 AutoCloseable 인터페이스를 상속받아야 사용 가능하다. (FileWriter는 상속받고 있다.)

```(java)
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResource {
	public static void main(String[] args) {
		try (FileWriter f = new FileWriter("data.txt")) {
			f.write("Hello");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

try-with-resource 문은 try 문에 괄호를 추가하여 사용할 자원을 정의한다. <br>
이때 여러 개의 객체를 선언할 수도 있고, 구분은 세미콜론을 통해 가능하다. <br>
단, 객체 정의의 가장 마지막에는 세미콜론을 넣지 않는다. <br>
이후 try 문(try, catch, finally 등)이 종료되면 생성된 인스턴스들은 자동으로 종료된다. <br>
따라서 명시적으로 close할 필요가 없어진다.