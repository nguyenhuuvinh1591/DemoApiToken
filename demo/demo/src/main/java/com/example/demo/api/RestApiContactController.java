package com.example.demo.api;

import com.example.demo.Entity.Contact;
import com.example.demo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/contact")
    public ResponseEntity<List<Contact>> listAllContact(){
        List<Contact> listContact= contactService.findAllContact();
        if(listContact.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Contact>>(listContact, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public Contact findContact(@PathVariable("id") long id) {
        Contact contact = contactService.findContactById(id);
        return contact;
    }

    @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
    public Contact saveContact(@RequestBody Contact contact) {
        Contact contact_temp = new Contact();
        contact_temp.setId(contact.getId());
        contact_temp.setName(contact.getName());
        contact_temp.setDob(contact.getDob());
        contact_temp.setAge(contact.getAge());
        contact_temp.setEmail(contact.getEmail());
        return contactService.saveContact(contact_temp);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") long contactId,
                                                 @RequestBody Contact contactForm){
        Contact contact = contactService.findContactById(contactId);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }
        contact.setAge(contactForm.getAge());
        contact.setName(contactForm.getName());

        Contact updateContact = contactService.saveContact(contact);
        return ResponseEntity.ok(updateContact);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Contact> deleteContact(@PathVariable(value = "id") Long id) {
        Contact contact = contactService.findContactById(id);
        if(contact == null) {
            return ResponseEntity.notFound().build();
        }

            contactService.deleteContact(contact);
        return ResponseEntity.ok().build();
    }
}
