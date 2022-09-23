<h1> <strong> 2. this & super </strong> </h1>

* this: 인스턴스 자기 자신을 가리키는 키워드
* super: 부모 클래스를 가리키는 키워드

우리는 this와 super 키워드를 사용해 아래와 같이 부모 클래스의 변수 및 메소드에 접근할 수 있다.

```(java)
class Cal(){
    public int sum(int v1, int v2){
        return v1+v2;
    }
    // overriding
    public int sum(int v1, int v2, int v3){
        // overriding 실행 시 이와 같이 계승 발전시키는 것이 좋다.
        return this.sum(v1, v2)+v3; 
    }
}

class Cal2 extends Cal{
    public int sum(int v1, int v2){
        System.out.println("Cal2");
        return super.sum(v1, v2);
    }

    public int minus(int v1, int v2){
        return v1-v2;
    }
}
```