-- Data awal. Tes DAO mengosongkan tabel aset dan peminjaman, tetapi tidak peminjam.
INSERT INTO peminjam (id, nama) VALUES ('P-01', 'Peminjam Contoh')
ON CONFLICT (id) DO NOTHING;
