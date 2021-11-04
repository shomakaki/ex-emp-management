package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

@Controller
public class AdministratorControllerSample {
		
	@Autowired
	private AdministratorRepository repository ;
	
	@RequestMapping("/sample")
	public String sample() {
		Administrator administrator = new Administrator();
		administrator.setName("デモ太郎");
		administrator.setMailAddress("demo@co.jp");
		administrator.setPassword("1111");
		
		
		repository.insert(administrator);
		repository.findByMailAdressAndPassword("iga@sample.com", "testtest");
		
		return "sample-result";
		
	}

}
