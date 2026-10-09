# Minggu 14: Integrasi Individu

Bobot: Observasi 1%, Laporan 1%, Praktikum 3%.

## Tujuan

- Menyambungkan seluruh lapisan: API, service, DAO, PostgreSQL.
- Menjalankan sistem lengkap dari nol.

## Yang dikerjakan

- Tulis implementasi JDBC dari `AsetRepository` di modul api (memakai DAO dari core) dan ganti `InMemoryAsetRepository`.
- Tambahkan endpoint peminjaman (ajukan, setujui, pinjam, kembalikan) memakai `JadwalPeminjaman`/`PeminjamanDAO`, `AturanDenda`.
- Tulis `Dockerfile` untuk api dan perluas `docker-compose.yml` hingga `docker compose up` menjalankan db dan api.
- Perbarui UML agar sesuai dengan kode akhir.
- Laporan singkat (template: `docs/templates/laporan.md`) minimal tiga butir kendala dan solusi.

## Aturan pasti (dipakai tes)

- Sistem berjalan dari nol hanya dengan `docker compose up`.
- Tidak ada SQL di controller. Lapisan: controller -> service -> repository/DAO.
- Enam sampai tujuh aturan ambigu dijawab di `docs/asumsi.md`, masing-masing dengan tes buatan Anda.
- FR-1 sampai FR-7 terpenuhi sebisa mungkin; catat yang belum di laporan.

## Keputusan Anda

- Seluruh arsitektur di luar kontrak yang sudah ada.

## Tes

Tes terbuka minggu 1-13 harus tetap hijau. Penilaian akhir oleh tes tersembunyi dan demo.

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Pengumpulan

- Commit dengan format `minggu-14: ringkasan`.
- Isi `catatan/minggu-14.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
