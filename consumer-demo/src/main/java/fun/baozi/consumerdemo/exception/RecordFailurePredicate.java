package fun.baozi.consumerdemo.exception;


import java.util.function.Predicate;

/**
 * @author meisen
 * @since 2021-11-03
 */
public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        return true;
    }
}