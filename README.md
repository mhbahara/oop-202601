# Praktikum OOP 202601: Aset-Pinjam

Repositori template mata kuliah Object Oriented Programming, Universitas Putra Bangsa, semester 202601.
Studi kasus: **Aset-Pinjam**, sistem peminjaman ruang, laptop, dan alat laboratorium kampus.
Semua tugas dikerjakan **individu**, bertahap selama 16 pertemuan pada satu proyek yang sama.

## Mulai dari sini

1. **Fork** repositori ini, ganti nama menjadi `oop-202601-<nim>`, lalu clone.
2. Tambahkan repositori dosen sebagai `upstream` (`git remote add upstream <url-repo-dosen>`).
   Tiap minggu: `git fetch upstream` lalu `git merge upstream/main` untuk mendapat tes dan dokumen baru.
3. Isi **`core/src/main/resources/mahasiswa.properties`** dengan NIM dan nama Anda.
   NIM menentukan varian aturan Anda (lihat [docs/varian.md](docs/varian.md)). Tes akan gagal sampai diisi.
4. Pasang JDK 21 dan Maven. Cek dengan `java -version` dan `mvn -v`.
5. Baca [docs/kebijakan-ai.md](docs/kebijakan-ai.md) sebelum mengerjakan apa pun.
6. Kerjakan minggu aktif: baca `docs/minggu-NN.md`, lengkapi bagian bertanda `TODO`, jalankan tes.

```bash
# Linux/macOS/Git Bash
bash scripts/uji.sh       # jalankan tes minggu 1 sampai minggu aktif
# Windows PowerShell
.\scripts\uji.ps1
```

`minggu-aktif.txt` diatur dosen dan ikut terbarui lewat `upstream`. Tes minggu yang belum aktif tidak dijalankan.

## Struktur

```
core/                   modul Java biasa: minggu 1 sampai 11 (model, jadwal, denda, factory, dao)
api/                    modul Spring Boot: minggu 12 sampai 15 (REST API)
sql/                    skema dan data awal PostgreSQL
docs/                   panduan mingguan, aturan bisnis, asumsi, UML, template
catatan/                catatan-ai dan refleksi per minggu (milik Anda)
scripts/                pembantu menjalankan tes
minggu-aktif.txt        minggu yang sedang berlaku (diatur dosen)
```

Folder `core/src/test/java/id/ac/upb/asetpinjam/mahasiswa/` adalah **milik Anda** untuk tes buatan sendiri.

## Cara kerja tiap minggu

1. Baca `docs/minggu-NN.md`.
2. Kerjakan `TODO` pada kode. Kelas yang bertanda **DISEDIAKAN dosen** jangan diubah.
3. Jalankan tes. Tes terbuka hanya menguji kasus yang jelas. Tes tersembunyi dosen (di UTS dan UAS) menguji lebih banyak.
4. Isi `catatan/minggu-NN.md` (salin dari `catatan/_template.md`), termasuk bagian pemakaian AI.
5. Commit dengan format `minggu-NN: ringkasan singkat`, lalu push. Bukti penilaian adalah CI hijau.

## Aturan penting

- Kerja individu. Berdiskusi boleh, menyalin kode tidak. Kode yang mirip akan ditandai otomatis.
- **AI boleh dipakai untuk tugas mingguan dengan pengungkapan** (lihat kebijakan). Kuis, UTS, dan change request UAS tanpa AI.
- Anda harus mampu menjelaskan setiap baris kode yang Anda kumpulkan. Sebagian mahasiswa akan diminta menjelaskan langsung.
- Kata sandi dan kredensial tidak boleh masuk ke repo. Gunakan `.env` (sudah di `.gitignore`).
- Aturan bisnis yang sengaja tidak dijelaskan dosen: putuskan sendiri dan catat di [docs/asumsi.md](docs/asumsi.md).

## Penilaian

| Komponen | Bobot |
|---|---|
| Praktikum (dinilai otomatis oleh CI) | 34% |
| Tugas (kuis tanpa AI, laporan) | 27% |
| Partisipatif | 5% |
| UTS (tertulis 7% + coding di lab 7%) | 14% |
| UAS (demo 10% + change request di lab 10%) | 20% |

Rincian per minggu ada di RPS dan matriks penilaian.

## Referensi

Liang, *Introduction to Java Programming and Data Structures*; Horstmann, *Core Java Vol. I*; Schildt, *Java: The Complete Reference*;
Spring Boot Reference Documentation; JUnit 5 User Guide; PostgreSQL Documentation.
