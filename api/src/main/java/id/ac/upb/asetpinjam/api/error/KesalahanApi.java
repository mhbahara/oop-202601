package id.ac.upb.asetpinjam.api.error;

import java.util.Map;

/**
 * DISEDIAKAN dosen. Bentuk JSON semua respons kesalahan:
 * {"status":400,"pesan":"...","kesalahan":{"namaField":"pesan per field"}}
 * ("kesalahan" boleh kosong untuk error non-validasi).
 */
public record KesalahanApi(int status, String pesan, Map<String, String> kesalahan) {
}
