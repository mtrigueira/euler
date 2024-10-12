package utils.sequence;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Stream;

public abstract class Sequence<T> implements Iterator<T> {
    private final Class<?> T_getClass = workOutClassOfTUsingReflection();
    public T[] nextArray(int sizeOfArray) {
        List<T> list = new ArrayList<>();
        long limit = sizeOfArray;
        for (T i = next(); hasNext(); i = next()) {
            if (limit-- == 0) break;
            list.add(i);
        }

        @SuppressWarnings("unchecked") // These objects are type T since list is <T>
        T[] array = list.toArray((T[]) Array.newInstance(T_getClass, sizeOfArray));
        return array;
    }

    private Class<?> workOutClassOfTUsingReflection() {
        try {
            ParameterizedType g = (ParameterizedType) getClass().getGenericSuperclass();
            Type typeT = g.getActualTypeArguments()[0];
            String nameOfT = typeT.getTypeName();
            return Class.forName(nameOfT);
        } catch (ClassNotFoundException|ClassCastException a) {
        }
        return null;
    }

    public Stream<T> stream() {
        return java.util.stream.StreamSupport.stream(Spliterators.spliteratorUnknownSize(this, Spliterator.ORDERED), false);
    }

    public abstract T next();

    @Override
    public abstract boolean hasNext();
}
