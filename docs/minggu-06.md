# Minggu 6: UML dan SOLID

Bobot: Quiz 2%, Tugas 3%, Praktikum 3%.

## Tujuan

- Memodelkan sistem dengan Class Diagram dan Sequence Diagram.
- Menunjukkan minimal dua prinsip SOLID di kode.

## Yang dikerjakan

- `docs/uml/class*`: Class Diagram dari kode Anda (atribut, method, tipe, visibility, relasi, multiplicity, paket).
- `docs/uml/sequence*`: Sequence Diagram pengajuan peminjaman, skenario sukses dan skenario bentrok (fragmen `alt`).
- `docs/uml/solid.md`: minimal dua prinsip SOLID, tunjuk kelas dan alasan.
- Refactor kecil di kode bila perlu agar prinsipnya terlihat.

## Aturan pasti (dipakai tes)

- Diagram harus konsisten dengan kode, bukan sketsa ideal.

## Keputusan Anda

- Prinsip SOLID mana yang Anda tunjukkan dan di kelas mana.

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu06DokumenTest.java` (hanya memeriksa berkas ada).

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Catatan

- Rubrik: Class Diagram 40%, Sequence Diagram 30%, SOLID 20%, konsistensi dengan kode 10%.
- Kuis tanpa AI: perbedaan aggregation dan composition; mengapa OCP memudahkan pengembangan; mengapa DIP meningkatkan testability.

## Pengumpulan

- Commit dengan format `minggu-06: ringkasan`.
- Isi `catatan/minggu-06.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
