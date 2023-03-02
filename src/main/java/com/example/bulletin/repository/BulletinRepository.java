package com.example.bulletin.repository;

import com.example.bulletin.entity.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulletinRepository extends JpaRepository<Bulletin, Long>{
    List<Bulletin> findAllByOrderByModifiedAtDesc();
}
