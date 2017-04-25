package riposte;

import com.google.common.collect.ImmutableList;
import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.exception.ApiException;
import com.nike.internal.util.Pair;
import com.nike.riposte.server.http.RequestInfo;
import io.netty.channel.ChannelHandlerContext;
import javaslang.control.Either;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static javaslang.control.Either.left;
import static javaslang.control.Either.right;
import static riposte.CoreApiError.INVALID_CREDENTIALS;
import static riposte.CoreApiError.MISSING_AUTHORIZATION;

@AllArgsConstructor
@Slf4j
public class SampleRequestProcessor
    implements RequestProcessor<ChannelHandlerContext, RequestInfo<?>, Either<ApiException, RequestInfo<?>>> {

  public static final String HEADER_1 = "header-1";
  public static final String HEADER_2 = "header-2";
  public static final String MY_ATTRIBUTE = "MY-ATTRIBUTE";

  @Override
  public Either<ApiException, RequestInfo<?>> apply(ChannelHandlerContext channelHandlerContext, RequestInfo<?> requestInfo) {
    return headerId1FromHeaders(requestInfo);
  }

  protected Either<ApiException, RequestInfo<?>> headerId1FromHeaders(RequestInfo<?> rInfo) {
    return null;
    /*return Option.of(rInfo.getHeaders().get(HEADER_1))
        .flatMap(headerId1 -> Option.of(rInfo.getHeaders().get(HEADER_2))
            .map(headerId2 -> Tuple.of(headerId1, headerId2)))
        .toRight(this::buildBadRequestResponse)
        .flatMap(pair -> validateheaderId1(pair._1, rInfo));*/
  }

  @SuppressWarnings("ResultOfMethodCallIgnored")
  protected Either<ApiException, RequestInfo<?>> validateheaderId1(String headerId1, RequestInfo<?> rInfo) {
    try {
      UUID.fromString(headerId1);
      rInfo.addRequestAttribute(MY_ATTRIBUTE, true);
      return right(rInfo);
    } catch (IllegalArgumentException e) {
      log.warn("Invalid header id: {}", headerId1);
      return left(authErrorResponse(INVALID_CREDENTIALS, "invalid token", "desc"));
    }
  }

  protected ApiException buildBadRequestResponse() {
    log.warn("Missing something and header ids.");
    return authErrorResponse(MISSING_AUTHORIZATION, "invalid request", "desc");
  }

  public static ApiException authErrorResponse(ApiError e, String wwwAuthError, String wwwAuthErrorDescription) {
    return ApiException.newBuilder()
        .withApiErrors(e)
        .withExtraResponseHeaders(
            Pair.of("WWW-Authenticate",
                ImmutableList.of(String.format("Bearer realm=\"null\",error=\"%s\",error_description=\"%s\"",
                    wwwAuthError,
                    wwwAuthErrorDescription))))
        .build();
  }

}
