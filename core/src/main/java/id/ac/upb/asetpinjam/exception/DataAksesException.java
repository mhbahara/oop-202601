package id.ac.upb.asetpinjam.exception;

/** DISEDIAKAN dosen. Kegagalan akses data (membungkus SQLException). */
public class DataAksesException extends AsetPinjamException {

    public DataAksesException(String pesan, Throwable sebab) {
        super(pesan, sebab);
    }
}
