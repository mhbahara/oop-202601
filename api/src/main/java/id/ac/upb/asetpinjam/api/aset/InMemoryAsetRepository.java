package id.ac.upb.asetpinjam.api.aset;

import id.ac.upb.asetpinjam.model.Aset;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

/** DISEDIAKAN dosen. Penyimpanan di memori agar minggu 12-13 tidak butuh database. */
@Repository
public class InMemoryAsetRepository implements AsetRepository {

    private final Map<String, Aset> data = new ConcurrentHashMap<>();

    @Override
    public void simpan(Aset aset) {
        data.put(aset.getKode(), aset);
    }

    @Override
    public Optional<Aset> cariByKode(String kode) {
        return Optional.ofNullable(data.get(kode));
    }

    @Override
    public List<Aset> semua() {
        return data.values().stream().sorted(Comparator.comparing(Aset::getKode)).toList();
    }

    @Override
    public boolean hapus(String kode) {
        return data.remove(kode) != null;
    }
}
