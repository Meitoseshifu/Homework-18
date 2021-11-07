package happy.outer;

import happy.learning.annotation.Trimmed;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        return aClass.isAnnotationPresent(Trimmed.class) ? createTrimmedProxy(aClass): bean;
    }

    private Object createTrimmedProxy(Class<?> aClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(aClass);
        enhancer.setInterfaces(aClass.getInterfaces());
        MethodInterceptor methodInterceptor = (Object obj, Method method, Object[] args, MethodProxy methodProxy) -> {
            trimMethodStringArgument(args);
            return method.getReturnType().equals(String.class) ? methodProxy.invokeSuper(obj, args).toString().trim()
                                                               : methodProxy.invokeSuper(obj, args);
        };
        enhancer.setCallback(methodInterceptor);
        return aClass.cast(enhancer.create());
    }

    private void trimMethodStringArgument(Object[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                args[i] = ((String) args[i]).trim();
            }
        }
    }

}
