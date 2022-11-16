package com.example.talaba.Repository;

import com.example.talaba.Entity.Guruh;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuruhRepozitary extends  JpaRepository<Guruh, Integer>{
    boolean existsByGuruhnomi(String guruhnomi);

}
