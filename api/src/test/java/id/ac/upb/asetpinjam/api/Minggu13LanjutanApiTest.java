package id.ac.upb.asetpinjam.api;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

/** Tiap tes memakai konteks baru supaya data di memori bersih. */
@Tag("week13")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class Minggu13LanjutanApiTest {

    @Autowired
    private MockMvc mvc;

    private void kirim(String json) throws Exception {
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON).content(json));
    }

    @Test
    void kodeKosongDitolakDenganPesanPerField() throws Exception {
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"jenis\":\"RUANG\",\"kode\":\"\",\"nama\":\"Aula\",\"kapasitas\":10}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.kesalahan.kode").exists());
    }

    @Test
    void jenisKosongDitolakDenganPesanPerField() throws Exception {
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"kode\":\"X-1\",\"nama\":\"Aula\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.kesalahan.jenis").exists());
    }

    @Test
    void aturanDomainYangDilanggarMenjadi400() throws Exception {
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"jenis\":\"RUANG\",\"kode\":\"R-1\",\"nama\":\"Aula\",\"kapasitas\":-5}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.pesan").exists());
    }

    @Test
    void kodeGandaMenjadi409() throws Exception {
        String json = "{\"jenis\":\"RUANG\",\"kode\":\"R-9\",\"nama\":\"Aula\",\"kapasitas\":10}";
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
        mvc.perform(post("/api/aset").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.status").value(409));
    }

    @Test
    void asetTidakDitemukanPunyaBentukKesalahanSeragam() throws Exception {
        mvc.perform(get("/api/aset/TIDAK-ADA"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.pesan").exists());
    }

    @Test
    void laporanAsetPerJenisMemakaiStream() throws Exception {
        kirim("{\"jenis\":\"RUANG\",\"kode\":\"R-1\",\"nama\":\"A\",\"kapasitas\":10}");
        kirim("{\"jenis\":\"RUANG\",\"kode\":\"R-2\",\"nama\":\"B\",\"kapasitas\":20}");
        kirim("{\"jenis\":\"LAPTOP\",\"kode\":\"L-1\",\"nama\":\"C\",\"spesifikasi\":\"i5\",\"nomorInventaris\":\"INV-1\"}");
        mvc.perform(get("/api/laporan/aset-per-jenis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.RUANG").value(2))
                .andExpect(jsonPath("$.LAPTOP").value(1));
    }

    @Test
    void dokumentasiOpenApiTersedia() throws Exception {
        mvc.perform(get("/v3/api-docs"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("/api/aset")));
    }
}
