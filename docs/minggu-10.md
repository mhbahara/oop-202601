# Minggu 10: Design Pattern dan Testing

Bobot: Laporan 2%, Praktikum 3%.

## Tujuan

- Menerapkan Strategy dan Factory.
- Menulis unit test sendiri.

## Yang dikerjakan

- `core/src/main/java/id/ac/upb/asetpinjam/factory/AsetFactory.java`: `buat`.
- `core/src/main/java/id/ac/upb/asetpinjam/denda/LayananDenda.java`: terima `AturanDenda` lewat konstruktor.
- `core/src/test/java/id/ac/upb/asetpinjam/mahasiswa/`: tulis **minimal 8 tes buatan sendiri** (belum termasuk contoh bawaan).

## Aturan pasti (dipakai tes)

- `AsetFactory.buat` menerima atribut sesuai jenis (RUANG: kapasitas; LAPTOP: spesifikasi, nomor inventaris; ALAT_LAB: laboratorium, tingkat risiko). Atribut salah jumlah, angka tidak valid, atau jenis null: `IllegalArgumentException`.
- `LayananDenda` memakai strategi yang disuntikkan; strategi null ditolak.
- Tes buatan Anda harus mencakup keputusan di `docs/asumsi.md` (minimal bentrok batas waktu).

## Keputusan Anda

- Tes apa saja yang Anda anggap paling penting dan kenapa (tulis di laporan).

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu10PatternTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Catatan

- Laporan singkat (template: `docs/templates/laporan.md`): manfaat testing yang Anda rasakan.

## Pengumpulan

- Commit dengan format `minggu-10: ringkasan`.
- Isi `catatan/minggu-10.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
