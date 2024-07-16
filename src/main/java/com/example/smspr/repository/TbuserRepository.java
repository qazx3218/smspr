package com.example.smspr.repository;

import com.example.smspr.domain.Tbuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//2024-07-11 추가(클래스 처음 추가함)
@Repository
public interface TbuserRepository extends JpaRepository<Tbuser, String> {
}