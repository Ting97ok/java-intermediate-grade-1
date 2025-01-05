package enumeration.test.http;

public enum HttpStatus {
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),;

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return 200 <= code && code <= 299;
    }

    public static HttpStatus findByCode(int httpCodeInput) {
        for (HttpStatus httpStatus : values()) {
            if (httpStatus.code == httpCodeInput) {
                return httpStatus;
            }
        }
        return null;
    }
}
