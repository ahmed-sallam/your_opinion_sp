package com.techpeak.your_openion.repo;

import com.techpeak.your_openion.entity.OpinionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OpinionRepository extends JpaRepository<OpinionEntity, Long> {
}
