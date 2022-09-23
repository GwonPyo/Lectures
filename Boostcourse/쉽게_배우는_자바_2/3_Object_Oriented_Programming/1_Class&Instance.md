<h1> <strong> 1. Class & Instance </strong> </h1>

<h1> <strong> (1) Class와 Instance 기본 개념 </strong> </h1>

먼저 class와 instance를 활용한 예시 코드를 살펴보자. 

```(java)
import java.io.FileWriter;
import java.io.IOException;

public class OthersOOP {
	public static void main(String[] args) throws IOException {
		System.out.println(Math.PI);
		System.out.println(Math.floor(1.8));
		System.out.println(Math.ceil(1.8));
		
		FileWriter f1 = new FileWriter("data1.txt");
		f1.write("Hello");
		f1.write("Java");
		
		FileWriter f2 = new FileWriter("data2.txt");
		f2.write("Hello");
		f2.write("Java");
		f2.close();
		
		f1.write("!!!");
		f1.close();
	}
}
```

Math 클래스는 수학적 계산을 도와주는 여러 메소드와 필드(변수)를 포함한다 <br>
이러한 메소드와 변수는 인스턴스를 생성하지 않아도 클래스에서 직접 호출할 수 있다.

반면 FileWriter 클래스는 파일을 열어서 원하는 내용을 입력할 수 있는 기능을 제공한다. <br>
그래서 각각의 파일에 해당하는 인스턴스를 생성하여 write 메소드로 쓰기 작업을 수행하고 close 메소드로 파일을 닫는다. <br>
이러한 메소드와 변수는 인스턴스를 생성하여 사용해야 하며 클래스에서 직접 호출할 수 없다.

<h1> <strong> (2) 클래스 </strong> </h1>

클래스를 사용하면 연관된 변수들과 메소드를 묶어 정리할 수 있다. <br>
아래는 클래스 사용 예시 코드다.

```(java)
class Print{
	public static String delimiter="";
	public static void A() {
		System.out.println(delimiter);
		System.out.println("A");
		System.out.println("A");
	}
	public static void B() {
		System.out.println(delimiter);
		System.out.println("B");
		System.out.println("B");
	}   
}

public class MyOOP {
	public static void main(String[] args) {
		Print.delimiter = "----";
		Print.A();
		Print.A();
		Print.B();
		Print.B();
		
		Print.delimiter = "****";
		Print.A();
		Print.A();
		Print.B();
		Print.B();
	}
}
```

우리는 이전부터 위와 같이 파일 이름과 동일한 이름의 클래스를 public class로 선언했다. <br>
자바는 파일 이름과 동일한 이름의 클래스를 찾아 해당 클래스의 main 메소드를 가장 먼저 실행한다. <br>
이때 public class로 선언된 클래스는 단 하나만 존재할 수 있고, 나머지는 모두 class로 선언해야 한다. <br>
참고로 위처럼 두 개의 클래스로 이루어진 파일을 컴파일하게 되면 두 개의 class파일(MyOOP.class, Print.class)이 생성된다. <br>

두 개의 클래스로 이루어진 파일은 두 개의 파일로 나누어 정리할 수 있다. <br>
eclipse의 경우 해당 클래스를 드래그하고 Refactor->Move Type to New File을 클릭하면 쉽게 파일을 생성할 수 있다. <br>
단, main문이 없는 클래스 역시 해당 파일의 이름과 동일한 클래스는 public class를 붙여 선언해야 한다. <br>

<h1> <strong> (2) 인스턴스 </strong> </h1>

```(java)
// Print.java 파일
public class Print{
	public String delimiter="";
	public void A() {
		System.out.println(delimiter);
		System.out.println("A");
		System.out.println("A");
	}
	public void B() {
		System.out.println(delimiter);
		System.out.println("B");
		System.out.println("B");
	}
}

// MyOOP.java 파일
public class MyOOP {
	public static void main(String[] args) {
		Print p1 = new Print();
		p1.delimiter = "----";
		p1.A();
		p1.A();
		p1.B();
		p1.B();
		
		Print p2 = new Print();
		p2.delimiter = "****";
		p2.A();
		p2.A();
		p2.B();
		p2.B();
	}
}
```

이전의 클래스를 사용한 코드는 다른 delimiter를 사용하기 위해서 계속 delimiter를 변경해줘야 했다. <br>
하지만 위처럼 인스턴스를 사용하면 delimiter를 처음에 정의하고 이후에는 다시 정의하지 않아도 된다. <br>
이때, 인스턴스의 메소드를 만들기 위해서는 기존의 static을 빼주고 public String, public void 형식으로 필드와 메소드를 선언해줘야 한다.