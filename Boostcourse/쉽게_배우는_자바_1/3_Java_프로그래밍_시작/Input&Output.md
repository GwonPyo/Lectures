<h1> <strong> Input & Output </strong> </h1>

아래와 같은 IOT 코드가 있다고 하자.

```(java)
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class OKJavaGoInHome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "JAVA APT 507";
        
        // Elevator call 
        Elevator myElevator = new Elevator(id);
        myElevator.callForUp(1);
         
        // Security off 
        Security mySecurity = new Security(id);
        mySecurity.off();
         
        // Light on
        Lighting hallLamp = new Lighting(id+" / Hall Lamp");
        hallLamp.on();
         
        Lighting floorLamp = new Lighting(id+" / floorLamp");
        floorLamp.on();
	}
}
```

이때 id를 바꾸기 위해서는 해당 코드를 계속 수정해줘야 한다. <br>
이럴 때는 id를 직접 입력받는 것이 편할 것이다. <br>
JOptionPane 함수를 사용하면 원하는 값을 입력받고 프로그램을 작동하도록 할 수 있다.
```(java)
import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.Security;

public class OKJavaGoInHomeInput {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = JOptionPane.showInputDialog("Enter a Id");
        String bright = JOptionPane.showInputDialog("Enter a Bright Level");
		
        // Elevator call 
        Elevator myElevator = new Elevator(id);
        myElevator.callForUp(1);
         
        // Security off 
        Security mySecurity = new Security(id);
        mySecurity.off();
         
        // Light on
        Lighting hallLamp = new Lighting(id+" / Hall Lamp");
        hallLamp.on();
         
        Lighting floorLamp = new Lighting(id+" / floorLamp");
        floorLamp.on();

        DimmingLights moodLamp = new DimmingLights(id+" mood Lamp");
        moodLamp.setBright(Double.parseDouble(bright));
        moodLamp.on();
	}
}
```

추가적으로 Double.parseDouble()함수를 사용하면 문자열을 Double형으로 변환할 수 있다.

하지만 위처럼 프로그램 실행마다 계속 id를 입력받는 것이 귀찮을 수 있다. <br>
이때 우리는 이 입력값들을 미리 정의해 놓을 수 있다. <br>
eclipse의 경우 아래와 같이 가능하다.

* Run -> Run Configuration -> java Application -> 원하는 프로젝트 선택 -> Arguments -> 원하는 입력값 입력 -> apply
* 입력값 입력시 java APT 507을 작성하면 java, APT, 507이 모두 따로따로 입력된다. <br>
따라서 큰 따옴표를 사용해 "Java APT 507"로 입력해야 올바르게 값을 받아올 수 있다.

이때 받아온 값들은 args라는 매개변수에 저장된다.