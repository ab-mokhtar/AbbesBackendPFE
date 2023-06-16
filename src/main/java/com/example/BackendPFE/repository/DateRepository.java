package com.example.BackendPFE.repository;

import com.example.BackendPFE.model.Charge;
import com.example.BackendPFE.model.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface DateRepository extends JpaRepository<Date,Long> {
    List<Date> findByDemandeId(Long Id);
    @Transactional
    void deleteByDemandeId(Long demandeId);
}
