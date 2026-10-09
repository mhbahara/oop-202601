package id.ac.upb.asetpinjam.dao;

import id.ac.upb.asetpinjam.exception.DataAksesException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** DISEDIAKAN dosen. Membuka koneksi dari variabel lingkungan DB_URL, DB_USER, DB_PASSWORD. */
public final class Koneksi {

    private Koneksi() {
    }

    public static Connection baru() {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("DB_URL belum diatur (lihat .env.example dan docker-compose.yml)");
        }
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DataAksesException("Gagal membuka koneksi database", e);
        }
    }
}
