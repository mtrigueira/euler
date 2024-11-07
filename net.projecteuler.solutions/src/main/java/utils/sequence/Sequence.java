package utils.sequence;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Stream;

public abstract class Sequence<T> implements Iterator<T> {
    private Class<?> T_getClass = null;
    public T[] nextArray(int sizeOfArray) {
        List<T> list = new ArrayList<>();
        for(int i = 0; i < sizeOfArray; i++) {
            if (!hasNext()) break;
            list.add(next());
        }

        if (T_getClass==null) T_getClass = workOutClassOfTUsingReflection();
        @SuppressWarnings("unchecked") // These objects are type T since list is <T>
        T[] array = list.toArray((T[]) Array.newInstance(T_getClass, list.size()));
        return array;
    }

    private Class<?> workOutClassOfTUsingReflection() {
        try {
            ParameterizedType g = (ParameterizedType) getClass().getGenericSuperclass();
            Type typeT = g.getActualTypeArguments()[0];
            String nameOfT = typeT.getTypeName();
            return Class.forName(nameOfT);
        } catch (ClassNotFoundException|ClassCastException ignored) {
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
