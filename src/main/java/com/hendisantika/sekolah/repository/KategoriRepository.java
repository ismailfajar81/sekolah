package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 14.23
 */
public interface KategoriRepository extends JpaRepository<Kategori, UUID> {
    Optional<Kategori> findById(UUID kategoriId);
}
