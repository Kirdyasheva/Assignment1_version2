/**
 * Created by Anastasia on 12.10.2017.
 */
public class Integer extends Primary {
    private long value;

    Integer(long value) {
        super(value);
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public String getString() {
        return java.lang.Long.toString(value);
    }

    public long calculate() {
        return value;
    }

    public String toJSON() {
        return "{" + "\"value\":" + "\"" + value + "\"" + "}";
    }
}
