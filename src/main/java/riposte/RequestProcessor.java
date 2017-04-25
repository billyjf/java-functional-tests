package riposte;

import javaslang.Function2;

@FunctionalInterface
public interface RequestProcessor<T1, T2, R> extends Function2<T1, T2, R> {
}