# Minggu 11: Persistensi Data: DAO dan JDBC

Bobot: Laporan 2%, Praktikum 3%.

## Tujuan

- Memisahkan akses data dari logika bisnis dengan DAO.
- Mengakses PostgreSQL dengan JDBC secara aman.

## Yang dikerjakan

- `core/src/main/java/id/ac/upb/asetpinjam/dao/JdbcAsetDAO.java` dan `JdbcPeminjamanDAO.java`.
- Jalankan database: salin `.env.example` ke `.env`, isi `DB_PASSWORD`, lalu `docker compose up -d`.
- Set variabel lingkungan `DB_URL`, `DB_USER`, `DB_PASSWORD` di terminal Anda.

## Aturan pasti (dipakai tes)

- Wajib `PreparedStatement`; dilarang menggabung string SQL dengan input.
- Gunakan try-with-resources; bungkus `SQLException` dengan `DataAksesException`.
- `simpan` kode ganda: `DataAksesException`.
- Pembuatan objek dari baris database memakai `AsetFactory`.
- Tidak ada SQL di luar kelas DAO.

## Keputusan Anda

- Cara memetakan hierarki aset ke satu tabel (skema sudah disediakan; boleh diubah, catat di asumsi).

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu11DaoTest.java` (butuh database; dilewati bila `DB_URL` tidak diatur).

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Pengumpulan

- Commit dengan format `minggu-11: ringkasan`.
- Isi `catatan/minggu-11.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
