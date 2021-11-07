package happy.learning.component;

import happy.learning.annotation.Trimmed;
import org.springframework.stereotype.Component;

@Component
@Trimmed
public class SayHello {

    public void hello(String helloString) {
        System.out.println(helloString);
    }

    public void hello(String helloString, int times) {
        while(times != 0) {
            System.out.println(helloString);
            times--;
        }

    }

    public void hello(String helloString, String hi, int times) {
        while(times != 0) {
            System.out.println(helloString);
            System.out.println(hi);
            times--;
        }
    }


}
