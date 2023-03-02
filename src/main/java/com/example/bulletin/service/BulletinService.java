package com.example.bulletin.service;

import com.example.bulletin.dto.BulletinRequstDto;
import com.example.bulletin.entity.Bulletin;
import com.example.bulletin.repository.BulletinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BulletinService {
    private final BulletinRepository bulletinRepository;

    // BulletinR저장하기
    @Transactional
    public Bulletin createBulletin(BulletinRequstDto bulletinRequstDto) {
        Bulletin bulletin = new Bulletin(bulletinRequstDto);
        bulletinRepository.save(bulletin);
        return bulletin;
    }

    @Transactional
    public Long update(Long id, BulletinRequstDto bulletinRequstDto) {

        return id;
    }

    @Transactional(readOnly = true) // 조회하기
    public List<Bulletin> getBulletin() {
        return bulletinRepository.findAllByOrderByModifiedAtDesc();
    }
    @Transactional
    public Long deleteBulletin(Long id) {
    bulletinRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Bulletin getBulletinId(Long id) {
        Bulletin bulletin =  bulletinRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않습니다.")
        );
        return bulletin;
    }
}
