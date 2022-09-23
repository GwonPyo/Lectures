<h1> <strong> 1. Interface </strong> </h1>

우리는 인터페이스를 사용하여 만들 클래스의 메소드 형식을 미리 선언할 수 있다. <br>
이때 인터페이스를 이용해 만드는 클래스는 인터페이스의 메소드를 정의해야 한다. <br>
그렇지 않은 경우 디버깅 자체가 되지 않는다. <br>
클래스가 인터페이스를 받아오는 경우 implements 키워드를 사용하면 된다.

```(java)
interface Calculable {
	int sum(int v1, int v2);
}
class RealCal implements Calculable {
	public int sum(int v1, int v2) {
		return v1 + v2;
	}	
}
```

<h3> <strong> (1) 인터페이스 형식 </strong> </h3>

인터페이스는 일반적으로 첫 번째 문자는 대문자로 작성하며 형용사 형태로 이름짓는다. <br>
인터페이스를 정의하고 클래스에서 사용할 때는 하나 이상의 인터페이스를 포함할 수 있다.

* 즉, 인터페이스를 사용하면 규격을 엄격하게 준수하도록 할 수 있다.

```(java)
interface Calculable {
    double PI = 3.14;
	int sum(int v1, int v2);
}
interface Printable{
    void print();
}
class RealCal implements Calculable, Printable {
	public int sum(int v1, int v2) {
		return v1 + v2;
	}		
    public void print(){
        System.out.println("This is RealCal");
    }
    public void printPI() {
    	System.out.println("method call: "+this.PI);
    }
}
public class InterfaceApp {
	public static void main(String[] args) {
		RealCal c = new RealCal();
		System.out.println(c.sum(2, 1));
		c.printPI();
		System.out.println("main call:"+c.PI);
	}
}
```

또한 인터페이스는 변수를 포함할 수 있으며 해당 변수는 이후 해당 인터페이스를 포함하는 클래스에서 사용 가능하다.