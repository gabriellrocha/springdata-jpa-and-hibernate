package com.gabrielcoding.jpa.repositories;

import com.gabrielcoding.jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {

}
