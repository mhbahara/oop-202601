# Minggu 9: Exception Handling

Bobot: Quiz 2%, Praktikum 3%.

## Tujuan

- Mendesain exception domain.
- Memastikan keadaan objek tetap konsisten saat terjadi kegagalan.

## Yang dikerjakan

- `core/src/main/java/id/ac/upb/asetpinjam/exception/PeminjamanBentrokException.java`, `KuotaHabisException.java`, `StatusTidakSahException.java`: ubah konstruktor agar pesan jelas.
- `core/src/main/java/id/ac/upb/asetpinjam/model/Peminjaman.java`: `ubahStatus`.
- `core/src/main/java/id/ac/upb/asetpinjam/jadwal/JadwalPeminjaman.java`: `ajukan`.

## Aturan pasti (dipakai tes)

- Perpindahan status mengikuti `docs/aturan-bisnis.md`; yang lain melempar `StatusTidakSahException` dan status tidak berubah.
- Pesan `StatusTidakSahException` menyebut status asal dan tujuan.
- `ajukan` bentrok: `PeminjamanBentrokException` (pesan memuat kode aset) dan jadwal tidak berubah.
- `ajukan` laptop saat kuota habis: `KuotaHabisException` (pesan memuat id peminjam dan angka kuota).
- Kuota hanya untuk laptop, dihitung dari peminjaman berstatus DISETUJUI atau DIPINJAM milik peminjam yang sama.
- Pesan exception tidak boleh masih berisi "TODO".

## Keputusan Anda

- Apakah DIAJUKAN dihitung dalam kuota? Apakah DITOLAK/DIBATALKAN masih menempati jadwal? Catat dan buat tesnya.

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu09ExceptionTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Pengumpulan

- Commit dengan format `minggu-09: ringkasan`.
- Isi `catatan/minggu-09.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
