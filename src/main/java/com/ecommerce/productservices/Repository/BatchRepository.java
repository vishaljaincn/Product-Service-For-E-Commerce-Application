package com.ecommerce.productservices.Repository;

import com.ecommerce.productservices.Model_Entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    @Override
    Optional<Batch> findById(Long aLong);
}
