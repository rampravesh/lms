package com.loans.lms.enums;

import java.util.HashMap;
import java.util.Map;

public enum LoanType {
    NONE(0),
    Home(1),
    PERSONAL(2),
    MEDICAL(3),
    VEHICLE(4),
    ;

    private final int loanType;

    LoanType(int loanType) {
        this.loanType= loanType;
    }

    public int getLoanType() {
        return loanType;
    }

    private static final Map<Integer, LoanType> BY_LABEL = new HashMap<>();

    static {
        for (LoanType e : values()) {
            BY_LABEL.put(e.getLoanType(), e);
        }
    }

    public static LoanType valueOfLabel(Integer label) {
        return BY_LABEL.get(label);
    }
}
