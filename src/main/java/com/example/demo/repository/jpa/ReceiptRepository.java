package com.example.demo.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repository.jpa.domain.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer>{

}
