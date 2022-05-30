package com.example.tourdefrancebackend.repository;

import com.example.tourdefrancebackend.model.Cykelhold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CykelholdRepository extends JpaRepository<Cykelhold, Integer> {
}
