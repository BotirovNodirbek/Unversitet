package com.example.talaba.Repository;

import com.example.talaba.Entity.Manzil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManzilRepository extends JpaRepository<Manzil,Integer> {
    @Override
    boolean existsById(Integer integer);
}
