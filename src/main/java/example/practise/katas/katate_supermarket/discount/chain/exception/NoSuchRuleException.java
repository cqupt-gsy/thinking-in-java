package example.practise.katas.katate_supermarket.discount.chain.exception;

public class NoSuchRuleException extends RuntimeException {
    public NoSuchRuleException() {
        super("No such discount rules");
    }
}
