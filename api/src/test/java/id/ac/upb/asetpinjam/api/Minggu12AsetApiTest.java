package id.ac.upb.asetpinjam.api;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@Tag("week12")
@SpringBootTest
@AutoConfigureMockMvc
class Minggu12AsetApiTest {

    @Autowired
    private MockMvc mvc;

    private static String ruang(String kode) {
        return """
                {"jenis":"RUANG","kode":"%s","nama":"Aula %s","kapasitas":80}
                """.formatted(kode, kode);
    }

    @Test
    void membuatAsetMengembalikan201DanIsiAset() throws Exception {
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON).content(ruang("R-12A")))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.kode").value("R-12A"))
                .andExpect(jsonPath("$.jenis").value("RUANG"))
                .andExpect(jsonPath("$.status").value("TERSEDIA"))
                .andExpect(jsonPath("$.kondisi").value("BAIK"));
    }

    @Test
    void mengambilAsetYangAda() throws Exception {
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON).content(ruang("R-12B")))
                .andExpect(status().isCreated());
        mvc.perform(get("/api/aset/R-12B"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nama").value("Aula R-12B"));
    }

    @Test
    void asetTidakAdaMengembalikan404() throws Exception {
        mvc.perform(get("/api/aset/TIDAK-ADA")).andExpect(status().isNotFound());
    }

    @Test
    void daftarAsetMemuatYangSudahDibuat() throws Exception {
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON).content(ruang("R-12C")));
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON).content(ruang("R-12D")));
        mvc.perform(get("/api/aset"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))));
    }

    @Test
    void menghapusAsetLaluTidakDitemukan() throws Exception {
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON).content(ruang("R-12E")));
        mvc.perform(delete("/api/aset/R-12E")).andExpect(status().isNoContent());
        mvc.perform(get("/api/aset/R-12E")).andExpect(status().isNotFound());
    }

    @Test
    void menghapusAsetYangTidakAdaMengembalikan404() throws Exception {
        mvc.perform(delete("/api/aset/TIDAK-ADA")).andExpect(status().isNotFound());
    }
}
