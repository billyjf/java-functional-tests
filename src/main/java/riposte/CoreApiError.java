package riposte;

import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.apierror.ApiErrorBase;

import java.util.Map;
import java.util.UUID;

import static com.nike.backstopper.apierror.ApiErrorConstants.HTTP_STATUS_CODE_BAD_REQUEST;
import static com.nike.backstopper.apierror.ApiErrorConstants.HTTP_STATUS_CODE_UNAUTHORIZED;

public enum CoreApiError implements ApiError {
  INVALID_CREDENTIALS(35, "Unauthorized", HTTP_STATUS_CODE_UNAUTHORIZED),
  MISSING_AUTHORIZATION(99001, "Missing required auth header", HTTP_STATUS_CODE_BAD_REQUEST);

  private final ApiError delegate;

  CoreApiError(ApiError delegate) {
    this.delegate = delegate;
  }

  CoreApiError(int errorCode, String message, int httpStatusCode) {
    this(new ApiErrorBase("delegated-to-enum-wrapper-" + UUID.randomUUID().toString(),
        errorCode,
        message,
        httpStatusCode));
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public String getErrorCode() {
    return null;
  }

  @Override
  public String getMessage() {
    return null;
  }

  @Override
  public Map<String, Object> getMetadata() {
    return null;
  }

  @Override
  public int getHttpStatusCode() {
    return 0;
  }
}
