package com.jhta.moviefan.restcontroller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhta.moviefan.dto.ResponseDto;
import com.jhta.moviefan.exception.RestLoginErrorException;
import com.jhta.moviefan.form.CustomerRegisterForm;
import com.jhta.moviefan.service.CustomerService;
import com.jhta.moviefan.utils.SessionUtils;
import com.jhta.moviefan.vo.Customer;

@RestController
@RequestMapping("/rest/home")
public class HomeRestController {
	
	static final Logger LOGGER = LogManager.getLogger(HomeRestController.class);
	
	@Autowired
	private CustomerService customerService;

	// 일반 로그인 요청 처리
	@PostMapping("/logincheck")
	public ResponseDto<String> checkPassword(String id, String password) {
		ResponseDto<String> response = new ResponseDto<String>();
		
		Customer customer = customerService.login(id, password);
		SessionUtils.addAttribute("LOGINED_CUSTOMER", customer);
		
		response.setStatus("OK");
		
		return response;
	}
	
	// 회원가입
	@PostMapping("/register")
	public ResponseDto<String> register(@RequestBody CustomerRegisterForm form) {
		ResponseDto<String> response = new ResponseDto<String>();
		Customer customer = new Customer();
		
		BeanUtils.copyProperties(form, customer);
		customer.setLoginType("NORMAL");
		
		customerService.registerCustomer(customer);
		response.setStatus("OK");
		
		return response;
	}
	
	// 아이디 찾기
	@PostMapping("/findid")
	public ResponseDto<String> findId(String name, String email) {
		ResponseDto<String> response = new ResponseDto<String>();
		Customer savedCustomer = customerService.getCustomerByEmail(email);
		
		if (savedCustomer == null) {
			throw new RestLoginErrorException("가입되지 않은 이메일입니다. 가입 후 이용해주세요.");
		}
		if (!savedCustomer.getName().equals(name)) {
			throw new RestLoginErrorException("사용자 정보가 일치하지 않습니다. 다시 확인해주세요.");
		}
		
		response.setStatus("OK");
		
		return response;
	}
	
	@PostMapping("/findpassword")
	public ResponseDto<String> findPassword(String name, String email, String id) {
		ResponseDto<String> response = new ResponseDto<String>();
		Customer savedCustomer = customerService.getCustomerByEmail(email);
		
		if (savedCustomer == null) {
			throw new RestLoginErrorException("가입되지 않은 이메일입니다. 가입 후 이용해주세요.");
		}
		if (!savedCustomer.getName().equals(name) || !savedCustomer.getId().equals(id)) {
			throw new RestLoginErrorException("사용자 정보가 일치하지 않습니다. 다시 확인해주세요.");
		}
		
		response.setStatus("OK");
		response.setItem(List.of("회원가입이 완료되었습니다."));
		
		return response;
	}
	
}



















