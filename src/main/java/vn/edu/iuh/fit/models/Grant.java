package vn.edu.iuh.fit.models;

public enum Grant {
    DISAABLE(0), ENABLE(1);

    private final int code;

    Grant(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Grant fromCode(int code) throws IllegalAccessException {
        for (Grant grant : Grant.values()) {
            if (grant.getCode() == code) {
                return grant;
            }
        }
        throw new IllegalAccessException("Invalid code: " + code);
    }
}
