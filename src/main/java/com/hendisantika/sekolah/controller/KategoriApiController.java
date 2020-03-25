package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.entity.Kategori;
import com.hendisantika.sekolah.exception.KategoriNotFoundException;
import com.hendisantika.sekolah.repository.KategoriRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/api/news")
public class KategoriApiController {

    @Autowired
    private KategoriRepository kategoriRepository;

    @PostMapping("categories")
    @ResponseBody
    public Kategori addNewKategori(@RequestBody @Valid Kategori kategori) {
        log.info("menambahkan kategori berita");
        return kategoriRepository.save(kategori);
    }

    @GetMapping("categories/{kategoriId}")
    public Kategori findKategoriById(@PathVariable(value = "kategoriId") UUID kategoriId) throws KategoriNotFoundException {
        log.info("filter kategori by id {}", kategoriId);
        return kategoriRepository.findById(kategoriId).orElseThrow(() -> {
            log.warn("Kategori Not Found not found.");
            return new KategoriNotFoundException("Kategori Not Found");
        });
    }

    @DeleteMapping("/categories/{kategoriId}")
    public List<Kategori> deleteKategori(@PathVariable("kategoriId") UUID kategoriId) {
        log.info("menghapus kategori berita");
        kategoriRepository.deleteById(kategoriId);
        return kategoriRepository.findAll();
    }

    @PutMapping("/categories/{kategoriId}")
    @ResponseBody
    public ResponseEntity<Kategori> updateKategoriFromDB(@PathVariable("kategoriId") UUID kategoriId, @RequestBody @Valid Kategori kategori) {
        log.info("memperbaharui kategori berita");
        Optional<Kategori> currentKategoriOpt = kategoriRepository.findById(kategoriId);
        Kategori currentKategori = currentKategoriOpt.get();
        currentKategori.setId(kategori.getId());
        currentKategori.setNama(kategori.getNama());

        return new ResponseEntity<>(kategoriRepository.save(currentKategori), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public List<Kategori> list() {
        log.info("List Down Data Kategori");
        return kategoriRepository.findAll();

    }
}