package app.studentrecordapp.Enums;

public enum Semester {
    One(1), Two(2);

    private final int value;
    private Semester(int value) {
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
