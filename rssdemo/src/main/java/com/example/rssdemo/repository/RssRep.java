package com.example.rssdemo.repository;

import com.example.rssdemo.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssRep extends JpaRepository<News, Long> {

}
