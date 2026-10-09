package id.ac.upb.asetpinjam.api.aset;

import id.ac.upb.asetpinjam.exception.AsetPinjamException;

/** DISEDIAKAN dosen. Dipetakan ke HTTP 409 oleh GlobalExceptionHandler (minggu 13). */
public class AsetSudahAdaException extends AsetPinjamException {

    public AsetSudahAdaException(String kode) {
        super("Aset dengan kode " + kode + " sudah ada");
    }
}
