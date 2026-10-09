# Varian Mahasiswa

Tiap mahasiswa mendapat parameter berbeda dari **digit terakhir NIM** (digit mod 5). Parameter dibaca otomatis oleh kelas
`Varian` (jangan diubah) dari `core/src/main/resources/mahasiswa.properties`.

| Digit terakhir NIM | Tarif denda per hari (Rp) | Batas durasi ruang (jam) | Kuota laptop |
|---|---|---|---|
| 0 atau 5 | 5.000 | 4 | 1 |
| 1 atau 6 | 7.500 | 6 | 2 |
| 2 atau 7 | 10.000 | 8 | 3 |
| 3 atau 8 | 2.500 | 3 | 1 |
| 4 atau 9 | 6.000 | 5 | 2 |

- **Tarif denda** dipakai pada `Aset.hitungDenda` (dikali multiplier jenis).
- **Kuota laptop** dipakai pada `JadwalPeminjaman.ajukan`.
- **Batas durasi ruang** dipakai pada tes tersembunyi (UTS dan UAS). Anda perlu menanganinya di aturan peminjaman ruang.

Dua mahasiswa dengan varian berbeda akan menghasilkan angka berbeda. Kode yang disalin dari teman dengan varian lain akan gagal tes Anda.
