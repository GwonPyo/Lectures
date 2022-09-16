<h1> <strong> Casting </strong> </h1>

```(java)
public class Casting {
	public static void main(String[] args) {
		double a = 1.1;
		double b = 1; 			// can convert from int to double
		System.out.println(b); 	
		
//		int c = 1.1;			// Error(cannot convert from double to int)
		int d = (int) 1.1;		// Casting
		
		String f = Integer.toString(1);
		System.out.println(f.getClass());
	}
}
```

* double b = 1;
    * integer형을 double 변수에 저장할 때는 정보적 손실이 없기 때문에 자동으로 변환된다.
* int d = (int) 1.1; 
    * double형을 int형 변수에 저장할 때는 소숫점 뒷자리에서 정보적 손실이 발생하므로 명시적으로 어떤 자료형으로 변경할지 써줘야 한다.
* Integer.toString()함수를 사용하면 숫자를 String 형으로 변환할 수 있다.