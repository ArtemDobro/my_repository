package by.epam.dobrohotov.englishWeb.utils;

import java.util.Objects;

public final class GenericTuple<F, S> {
    private final F first;
    private final S second;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericTuple<?, ?> that = (GenericTuple<?, ?>) o;
        return Objects.equals(first, that.first) && Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public GenericTuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Tuple(first=" + first + ", second=" + second + ")";
    }

}
