package enumeration.ex3;

public enum Grade {
    BASIC, GOLD, DIAMOND;

    public String toString() {
        return name() + "-" + ordinal();
    }
}