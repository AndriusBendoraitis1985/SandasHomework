package app.object;

import java.util.HashMap;
import java.util.Map;

public enum SalaryType {
    PRIEDAS("Priedas"),
    ALGA("Alga"),
    ATOSTOGINIAI("Atostoginiai"),
    PREMIJA("Premija");

    private final String type;
    private static final Map<String, SalaryType> enumBySalaryType = new HashMap<>();

    static {
        for (SalaryType enumValue : values()) {
            enumBySalaryType.put(enumValue.type, enumValue);
        }
    }

    SalaryType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public static SalaryType getEnumBySalaryType(String type) {
        return enumBySalaryType.get(type);
    }
}

