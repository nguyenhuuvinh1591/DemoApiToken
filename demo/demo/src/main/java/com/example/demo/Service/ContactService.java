package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Contact;
import com.example.demo.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@ComponentScan
public class ContactService {
	@Autowired
	ContactRepository contactRepository;

	public List<Contact> findAllContact(){
		return contactRepository.findAll();
	}

	public Contact findContactById(Long id){
		return contactRepository.getOne(id);
	}

	public Contact saveContact(Contact contact){
		return contactRepository.save(contact);
	}

	public void deleteContact(Contact contact){
		contactRepository.delete(contact);
	}

	public long count(){
		return contactRepository.count();
	}
}
