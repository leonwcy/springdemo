package demo.service.annotation;

import jdk.internal.instrumentation.InstrumentationMethod;
import jdk.nashorn.internal.objects.annotations.Function;

@FunctionalInterface
public interface IService {

    void dowork();
}
