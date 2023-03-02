package com.example.bulletin.entity;

import com.example.bulletin.dto.BulletinRequstDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Entity
@NoArgsConstructor
public class Bulletin extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // JSON 형태로 매개 변수 대신 이렇게 써줘도 된다?
    public Bulletin(BulletinRequstDto bulletinRequstDto) {
        this.username = bulletinRequstDto.getUsername();
        this.contents = bulletinRequstDto.getContents();
        this.title = bulletinRequstDto.getTitle();
        this.password = bulletinRequstDto.getPassword();
    }

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String password;
}
