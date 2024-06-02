package com.kafka.consumer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kafka.consumer.entity.Wikimedia;

public interface WikimediaRepository extends JpaRepository<Wikimedia, Long> {
}
