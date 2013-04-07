package com.jverstry.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SomeItemRepository
        extends JpaRepository<SomeItem, Long> {
    
}
