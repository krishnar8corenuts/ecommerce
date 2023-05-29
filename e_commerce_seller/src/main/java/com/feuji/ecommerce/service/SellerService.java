package com.feuji.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.ecommerce.dto.Seller;
import com.feuji.ecommerce.dto.SellerAddress;
import com.feuji.ecommerce.dto.SellerRegisterAddress;
import com.feuji.ecommerce.repository.SellerAddressRepository;
import com.feuji.ecommerce.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	SellerRepository sellerRepository;
	@Autowired
	SellerAddressRepository addressRepository;
	
	Seller repeatSeller;

	public Seller saveSeller(SellerRegisterAddress sellerAddress) {
		Seller seller = new Seller();
		seller.setSellerName(sellerAddress.getSellerName());
		seller.setGender(sellerAddress.getGender());
		seller.setMailId(sellerAddress.getMailId());
		seller.setPassword(sellerAddress.getPassword());
		seller.setMobileNumber(sellerAddress.getMobileNumber());
		
		SellerAddress address = new SellerAddress();
		address.setLocation(sellerAddress.getLocation());
		address.setPincode(sellerAddress.getPincode());
		address.setCity(sellerAddress.getCity());
		address.setLandmark(sellerAddress.getLandmark());
		address.setUser(seller);
		List<SellerAddress> list = new ArrayList();
		list.add(address);
		seller.setAddress(list);
		seller.getSellerId();
		return sellerRepository.save(seller);
	}

	public void deleteSeller(int sellerId) {
		
		sellerRepository.deleteById(sellerId);
		
	}
	public List<Seller> getAllSellers() {
		return sellerRepository.findAll();
	}
	
	public int login(String mailId,String password) {
		 Seller seller = sellerRepository.findByMailIdAndPassword(mailId, password);
		 repeatSeller = seller;
		 if(seller!=null) {
			 return seller.getSellerId();
		 }
		 else {
			 return 0;
		 }
	}
	
	public void addAddress(SellerAddress address) {
		int id = repeatSeller.getSellerId();
		List<Seller> list = getAllSellers();
		for(Seller seller : list) {
			if(seller.getSellerId() == id) {
				address.setUser(seller);
			}
		}
		addressRepository.save(address);
	}
	
	public List<String> getAllLocations()
	{
		return sellerRepository.getAllLoactions();
	}
	

}