<h1> <strong> 3. Constructor & this </strong> </h1>

클래스는 인스턴스를 생성할 때 클래스와 같은 이름의 생성자를 통해 인스턴스를 만든다. <br>
자바는 클래스에 생성자강 없다면 기본 생성자를 포함하도록 한다. <br>

* 이전에 만든 Print()와 같이 아무것도 지정하지 않는 생성자를 기본 생성자라고 한다. <br>

만약 인스턴스를 생성할 때부터 필드를 초기화하고 싶다면, 필드를 초기화하도록 생성자를 구성할 수 있다. <br>
이때 생성자는 접근 권한을 설정할 수 있고, 리턴 타입은 없으며 초기화할 필드에 따라 파라미터를 설정한다. <br>
다음은 실습 코드다. <br>

```(java)
// Print.java 파일
public class Print{
	public String delimiter="";
	public Print(String delimiter) {
		this.delimiter = delimiter;
	}
	
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
```