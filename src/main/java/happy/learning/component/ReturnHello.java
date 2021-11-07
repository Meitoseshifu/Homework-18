package happy.learning.component;

import happy.learning.annotation.Trimmed;
import org.springframework.stereotype.Component;

@Component
@Trimmed
public class ReturnHello {

    public String hello() {
        return "   HELLO   ";
    }
}
