package com.example.demo.Repository;

import com.example.demo.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long>{

}
