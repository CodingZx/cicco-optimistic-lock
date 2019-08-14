package lol.cicco.optimisticlock.exception;

public class OptimisticLockException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public OptimisticLockException() {
        super();
    }

    public OptimisticLockException(String msg) {
        super(msg);
    }

    public OptimisticLockException(Throwable e) {
        super(e);
    }
}
