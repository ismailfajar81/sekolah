package com.hendisantika.sekolah.repository;

import com.hendisantika.sekolah.dto.SiswaDto;
import com.hendisantika.sekolah.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 18/03/20
 * Time: 18.52
 */
public interface SiswaRepository extends JpaRepository<Siswa, UUID> {
    @Query(value = "SELECT tbl_siswa.*,nama FROM tbl_siswa JOIN tbl_kelas ON id=d;",
            nativeQuery = true)
    List<SiswaDto> findSiswa();
}
