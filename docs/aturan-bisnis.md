# Aturan Bisnis Aset-Pinjam

Dokumen ini membagi aturan menjadi **aturan pasti** (dosen sudah memutuskan, dipakai tes) dan **aturan ambigu** (Anda yang memutuskan).

## Aktor

| Aktor | Peran |
|---|---|
| Peminjam | Mahasiswa atau dosen. Mengajukan, membatalkan, dan mengembalikan peminjaman. |
| Petugas | Memeriksa serah terima dan pengembalian, mencatat kondisi aset. |
| Admin | Mengelola aset, aturan, dan laporan. |

## Jenis aset

| Jenis | Atribut khas | Multiplier denda |
|---|---|---|
| Ruang | kapasitas (> 0) | 1x |
| Laptop | spesifikasi, nomor inventaris | 2x |
| Alat Lab | laboratorium, tingkat risiko | 4x |

Atribut dasar semua aset: kode (tetap), nama, status (TERSEDIA, DIPINJAM, RUSAK), kondisi (BAIK, RUSAK_RINGAN, RUSAK_BERAT).

## Aturan pasti

1. Denda keterlambatan aset = `jumlah hari terlambat x multiplier jenis x tarif dasar varian Anda` (lihat [varian.md](varian.md)). Hari negatif ditolak.
2. Aset boleh dipinjam hanya jika statusnya TERSEDIA dan kondisinya bukan RUSAK_BERAT.
3. Waktu selesai peminjaman harus setelah waktu mulai.
4. Dua peminjaman pada **aset yang sama** dengan rentang waktu yang jelas tumpang tindih adalah bentrok. Aset berbeda tidak pernah bentrok.
5. Kuota laptop: satu peminjam tidak boleh memegang lebih dari `kuotaLaptop` (varian Anda) laptop yang aktif (status DISETUJUI atau DIPINJAM) sekaligus. Kuota hanya berlaku untuk laptop.
6. Perpindahan status peminjaman yang sah:

```
DIAJUKAN  -> DISETUJUI, DITOLAK
DISETUJUI -> DIPINJAM, DIBATALKAN
DIPINJAM  -> DIKEMBALIKAN, TERLAMBAT
TERLAMBAT -> DIKEMBALIKAN
DITOLAK, DIBATALKAN, DIKEMBALIKAN -> (akhir, tidak bisa berpindah lagi)
```

Perpindahan di luar daftar ini melempar `StatusTidakSahException`.

## Aturan ambigu (keputusan Anda)

Putuskan, tulis alasannya di [asumsi.md](asumsi.md), dan **tuliskan tes Anda sendiri** di `core/src/test/java/id/ac/upb/asetpinjam/mahasiswa/`.

1. Apa definisi bentrok di batas waktu? Peminjaman 09:00-11:00 dan 11:00-13:00 pada aset yang sama: bentrok atau tidak?
2. Bagaimana denda dihitung bila terlambat 1 menit atau 25 jam? (Sistem hanya mengenal hari bulat pada `hitungDenda`.)
3. Bolehkah satu peminjam meminjam aset yang sama dua kali pada hari yang sama?
4. Siapa menanggung biaya bila kondisi aset saat kembali lebih buruk dan tidak ada saksi?
5. Apa yang terjadi pada pengajuan yang sudah disetujui bila aset dinyatakan rusak sebelum serah terima?
6. Apakah pembatalan mendadak (kurang dari 1 jam sebelum mulai) dikenai sanksi? Bolehkah DIAJUKAN langsung DIBATALKAN?
7. Apakah peminjaman berstatus DITOLAK atau DIBATALKAN masih menempati jadwal? Apakah DIAJUKAN dihitung dalam kuota?

## Fitur lengkap (FR)

| Kode | Kebutuhan |
|---|---|
| FR-1 | Kelola aset: tambah, ubah, hapus, cari |
| FR-2 | Ajukan peminjaman |
| FR-3 | Validasi pengajuan: bentrok, kuota, batas durasi |
| FR-4 | Persetujuan sesuai jenis aset |
| FR-5 | Serah terima dan pengembalian |
| FR-6 | Hitung denda dengan aturan yang bisa diganti (Strategy) |
| FR-7 | Laporan per periode dan per jenis |
