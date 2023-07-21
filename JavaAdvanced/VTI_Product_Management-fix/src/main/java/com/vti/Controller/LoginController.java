package com.vti.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.Dto.LoginDto;
import com.vti.Entity.Account;
import com.vti.Service.IAccountService;

@RestController
@RequestMapping(value = "api/v2/login")
@CrossOrigin("*")
public class LoginController {
	@Autowired
	private IAccountService accountService;

	@GetMapping()
	public ResponseEntity<?> login(Principal principal) {
		// Nhận lại thông tin username của Account đăng nhập từ Principal
		String username = principal.getName();
		// Tìm account dưới DB
		Account account = accountService.getAccountByUsername(username);

//		Chuyển đổi dữ liệu để gửi về FE
		LoginDto loginDto = new LoginDto();
		loginDto.setId(account.getId());
		loginDto.setFullName(account.getFullname());
		loginDto.setStatus(account.getStatus().toString());

		return new ResponseEntity<>(loginDto, HttpStatus.OK);

	}
}
