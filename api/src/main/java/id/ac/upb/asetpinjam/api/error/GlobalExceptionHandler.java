package id.ac.upb.asetpinjam.api.error;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Minggu 12-13: satu tempat memetakan exception ke respons HTTP berbentuk KesalahanApi.
 *
 * <p>Pemetaan yang diuji:
 * AsetTidakDitemukanException -> 404; AsetSudahAdaException -> 409;
 * MethodArgumentNotValidException (validasi @Valid) -> 400 dengan "kesalahan" berisi pesan per field;
 * IllegalArgumentException (mis. dari AsetFactory) -> 400.
 *
 * <p>TODO: tambahkan metode @ExceptionHandler untuk masing-masing.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
}
