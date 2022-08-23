package com.omglobal.omglobal.repository;

import com.omglobal.omglobal.model.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse,Long> {
}
