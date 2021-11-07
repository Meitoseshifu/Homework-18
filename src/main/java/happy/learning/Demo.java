package happy.learning;

import happy.learning.component.ReturnHello;
import happy.learning.component.SayHello;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("happy.learning");

        SayHello sayHello = context.getBean(SayHello.class);
        sayHello.hello("      HELLO      ");
        sayHello.hello("      HELLO      ", 2);
        sayHello.hello("      HELLO      ", "    HI      ", 3);

        ReturnHello returnHello = context.getBean(ReturnHello.class);
        System.out.println(returnHello.hello());
    }
}
