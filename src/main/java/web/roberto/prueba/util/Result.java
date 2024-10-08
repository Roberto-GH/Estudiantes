package web.roberto.prueba.util;

import lombok.Getter;

@Getter
public class Result<T> {

  private final T value;
  private final boolean isSuccess;
  private final int code;
  private final String error;

  public Result(T value, boolean isSuccess, int code, String error) {
    this.value = value;
    this.isSuccess = isSuccess;
    this.code = code;
    this.error = error;
  }

  public static <T> Result<T> success(T value, int code) {
    return new Result<>(value, true, code, null);
  }

  public static <T> Result<T> failure(String error, int code) {
    return new Result<>(null, false, code, error);
  }

}
