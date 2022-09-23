<h1> <strong> 1. Method </strong> </h1>

메소드는 아래와 같은 방식처럼 사용할 수 있다.

```(java)
public class WhyMethod {
	public static void main(String[] args) {
		// virtual codes..
		printTwoTimesA();
		// virtual codes..
		printTwoTimesA();
		// virtual codes..
	}

	private static void printTwoTimesA() {
		System.out.println("-");
		System.out.println("A");		
		System.out.println("A");
	}
}
```

만약 수 천, 수 만개의 코드가 존재할 때 여러 번 반복되는 코드가 있다고 하자. <br>
만약 해당하는 작업의 코드를 수정해야 하는 상황이 온다면 이 작업에 해당하는 코드를 모두 찾아서 일일이 고쳐야 한다. <br>
이를 쉽게 하기 위해 위와 같이 메소드를 사용할 수 있으며 메소드를 사용하면 같은 <b>코드를 재사용하고, 유지보수가 쉬워진다.</b>

만약 이미 있는 코드에서 동일한 작업의 코드를 메소드로 바꿔주고 싶다면 아래와 같은 방식을 사용해도 된다.

1. 해당하는 코드를 선택한다.
2. Refactor를 누른다.
3. Extract Method를 선택하고 원하는 메소드의 이름 및 Access modifier를 선택하여 메소드를 생성한다.

<h3> <strong> 메소드의 입력 </strong> </h3>

메소드는 다음과 같이 임의의 값들을 입력받을 수 있다. <br>

```(java)
public class InputMethod {
	public static void main(String[] args) {
		// virtual codes..
		printTwoTimes("A", "-");
		// virtual codes..
		printTwoTimes("B", "*");
		// virtual codes..
		printTwoTimes("A", "&");
		printTwoTimes("B", "!");
	}

	private static void printTwoTimes(String text, String delimiter) {
		System.out.println(delimiter);
		System.out.println(text);		
		System.out.println(text);
	}
}
```

위와 같이 text, delimiter와 같은 것들을 <b>매개변수(parameter)</b>라고 부른다. <br>
메소드 생성 후 printTwoTimes("A", "&");와 같이 메소드를 호출하게 되는데 이때 A와 &과 같은 실제 데이터들을 인자(Argument)라고 부른다. 

<h3> <strong> 메소드의 출력 </strong> </h3>

위에서 만든 코드를 살펴보면 printTwoTimes 메소드는 받아온 파라미터를 콘솔창에 출력한다. <br>
이때 같은 내용을 파일에 출력하고 싶은 경우 새로운 메소드를 다시 만들어야 한다. <br>
하지만 위 방식으로 2개의 메소드는 만들지 않고 하나의 메소드만을 만들고 콘솔창과 파일에 같은 내용을 작성할 수 있다. <br>
이때 우리는 메소드의 return을 통해 메소드가 반환한 값을 사용한다.

```(java)
import java.io.FileWriter;
import java.io.IOException;

public class WhyMethod {
	public static void main(String[] args) throws IOException {
		System.out.println(twoTimes("a", "-"));
		FileWriter fw = new FileWriter("out.txt");
		fw.write(twoTimes("a", "*"));
		fw.close();
	}
	
	private static String twoTimes(String text, String delimiter) {
		String out = "";
		out = out+delimiter+'\n';
		out = out+text+'\n';
		out = out+text+'\n';
		return out;
	}
}
```

메소드가 위처럼 데이터를 반환하기 위해서는 아래와 같은 조건이 있다.

* 함수 선언시 반환되는 데이터 타입을 선언해야 한다.
* return을 통해 데이터를 반환해야 한다. 

