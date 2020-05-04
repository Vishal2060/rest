package com.example.demo.controller.impl;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.demo.controller.ContactController;
import com.example.demo.model.Contact;

@Controller
public class ContactControllerImpl implements ContactController {

	@Override
	public List<Contact> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact add(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Integer id, Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
