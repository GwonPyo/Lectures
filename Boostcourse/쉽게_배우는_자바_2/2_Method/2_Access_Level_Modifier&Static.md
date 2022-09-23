<h1> <strong> 2. Access Level Modifier & Static </strong> </h1>

<h3> <strong> (1) Access Level Modifier </strong> </h3>

아래는 private 사용 예제다. <br>

```(java)
class Greeting{
	private static void hi() {
		System.out.println("hi");
	}
}

public class AccessLevelModifiersMethod {
	private static void hi() {
		System.out.println("hi");
	}
	
	public static void main(String[] args) {
		hi();
		// Greeting.hi(); // hi is private
	}
}
```

위처럼 private method는 같은 클래스 내에 있는 다른 메소드에서는 사용가능하지만 다른 클래스에 있는 함수에서는 사용할 수 없다. <br>
즉, private method는 그 클래스 내부에서만 쓸 수 있는 메소드인 것이다. <br>
하지만 public method는 외부 클래스에서도 사용가능하다. <br>
일반적으로 private은 외부에서 굳이 알필요도 없거나 알아서는 안되는 것들을 위해 지정하며 public은 바깥으로 드러나서 호출할 수 있는 것들을 위해 지정한다. <br>

<h3> <strong> (2) Static </strong> </h3>

static이 붙은 method는 class의 메소드이고 static이 붙지 않은 method는 instance의 메소드이다.

* static - class method
* no static - instance method

아래는 static 예시 코드다.

```(java)
class Print{
	public String delimiter;    
	
	public void a() {
        // instance method
		System.out.println(this.delimiter);
		System.out.println("a");
		System.out.println("a");
	}
	
	public void b() {
        // instance method
		System.out.println(this.delimiter);
		System.out.println("b");
		System.out.println("b");
	}
	
	public static void c(String delimiter) {
        // class method
		System.out.println(delimiter);
		System.out.println("c");
		System.out.println("c");
	}
	
}

public class StaticMethod {
	public static void main(String[] args) {
		// instance1
		Print t1 = new Print();
		t1.delimiter = "-";
		t1.a();
		t1.b();
		
		// instance2
		Print t2 = new Print();
		t2.delimiter = "*";
		t2.a();
		t2.b();
		
		// Print.a();   // a() method is not static.
		Print.c("---"); // c() method is static.
	}
}
```