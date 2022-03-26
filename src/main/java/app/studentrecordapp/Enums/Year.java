package app.studentrecordapp.Enums;

public enum Year {
    One(1), Two(2),Three(3),Four(4);

    private final int value;
    private Year(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue()+"";
    }
}