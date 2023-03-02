package com.example.bulletin.controller;

import com.example.bulletin.dto.BulletinRequstDto;
import com.example.bulletin.entity.Bulletin;
import com.example.bulletin.repository.BulletinRepository;
import com.example.bulletin.service.BulletinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BulletinController {

    private final BulletinService bulletinService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/bulletin")
    public Bulletin createBulletin(@RequestBody BulletinRequstDto bulletinRequstDto){
        return bulletinService.createBulletin(bulletinRequstDto);
    }

    @GetMapping("api/bulletin")
    public List<Bulletin> getMemos() {
        return bulletinService.getBulletin();
    }
    @PutMapping("/api/bulletin/{id}")
    public Long updateBulletin(@PathVariable Long id, @RequestBody BulletinRequstDto bulletinRequstDto){
        return bulletinService.update(id, bulletinRequstDto);
    }
    @DeleteMapping("/api/bulletin/{id}")
    public Long deleteBulletin(@PathVariable Long id) {
        return bulletinService.deleteBulletin(id);
    }
}

