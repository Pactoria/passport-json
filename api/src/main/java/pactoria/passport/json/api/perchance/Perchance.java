package pactoria.passport.json.api.perchance;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public final class Perchance<T> {
    private static final Object ABSENT_VALUE = new Object();
    private static final Perchance<?> ABSENT = new Perchance<>(ABSENT_VALUE);

    public static <T> Perchance<T> of(T value) {
        return new Perchance<>(Objects.requireNonNull(value));
    }

    @SuppressWarnings("unchecked")
    public static <T> Perchance<T> absent() {
        return (Perchance<T>) ABSENT;
    }

    public static <T> Optional<T> flatOpt(Perchance<Optional<T>> perchance) {
        return perchance.toOptional().flatMap(Function.identity());
    }

    private final T value;

    private Perchance(T value) {
        this.value = value;
    }

    public boolean isAbsent() {
        return value == ABSENT_VALUE;
    }

    public T get() {
        if (isAbsent()) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public Optional<T> toOptional() {
        if(isAbsent()) {
            return Optional.empty();
        }
        return Optional.of(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perchance<?> perchance = (Perchance<?>) o;
        return Objects.equals(value, perchance.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        if(isAbsent())
            return "Perchance.absent";
        return "Perchance{" +
                this.value +
                '}';
    }

    public <R> Perchance<R> map(Function<T, R> mapper) {
        return isAbsent() ? Perchance.absent() : Perchance.of(mapper.apply(value));
    }
}
