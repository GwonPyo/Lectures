<h1> <strong> 2. Polymorphism </strong> </h1>

이전에 우리는 인스턴스를 선언할 때 다음과 같이 선언했다.

* class_name instance_name = new class_name(parameters...)

이때 우리는 좌측의 class_name을 변경하여 new class_name(parameters...)이 다양한 얼굴을 가지도록 할 수 있는데 이를 다형성(Polymorphism)이라고 부른다. <br>

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
		c.print();
        c.printPI();
		System.out.println("main call:"+c.PI);
	}
}
```

위 코드는 Interface.md에서 작성한 코드의 일부다. <br>
이때 'RealCal c = new RealCal();'을 두 가지 방법으로 바꿀 수 있다.

* Calculable c = new RealCal();
    - 이 경우 Calculable에 해당하는 함수 및 변수만 사용할 수 있다.
    - 즉, c.printPI();와 c.printPI();는 사용할 수 없다.
* Printable c = new RealCal();
    - 이 경우 Printable에 해당하는 함수 및 변수만 사용할 수 있다.
    - 즉, c.print();만 사용가능하다.

