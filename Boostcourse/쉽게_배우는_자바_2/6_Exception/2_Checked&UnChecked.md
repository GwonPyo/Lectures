<h1> <strong> 2. Checked vs. UnChecked </strong> </h1>

exception은 크게 두 가지로 나뉜다.

* Checked Exception
    - Exception에서 Runtime Exception을 제외한 나머지 Exception이 포함된다.
    - Checked Exception은 try catch 문 등으로 잡아내지 않으면 프로그램이 컴파일 조차 되지 않는다. <br>
    따라서 Checked Exception은 꼭 예외 처리를 해줘야 한다. <br>
    - Ex) IOException: FileWriter 사용시 발생하는 예외
* UnChecked Exception   
    - Runtime Exception을 포함한 그 자식들이 포함된다.
    - 우리가 이전에 처리했던 ArithmeticException, ArrayIndexOutOfBoundsException은 컴파일해서 실행할 수 있었다. <br> 이와 같은 예외들이 UnChecked Exception이다.

다음은 Checked Exception 예시 코드다.

```(java)
import java.io.FileWriter;
import java.io.IOException;

public class CheckedExceptionApp {
	public static void main(String[] args) {
		try {
			FileWriter f = new FileWriter("data.txt");
			f.write("Hello");
			f.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
```