package com.vti.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.Dto.AccountDto;
import com.vti.Entity.Account;
import com.vti.Form.AccountFormForCreating;
import com.vti.Form.AccountFormForUpdating;
import com.vti.Service.IAccountService;

@RestController
@RequestMapping(value = "api/v2/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accountService;

// Get All Accout
	@GetMapping()
	public ResponseEntity<?> getAllAccount() {
		List<Account> accounts = accountService.getAllAccount();
		// Chuyển đổi dữ liệu
		List<AccountDto> accountDtos = new ArrayList<>();

		for (Account account : accounts) {
			AccountDto accountDto = new AccountDto();
			accountDto.setId(account.getId());
			accountDto.setEmail(account.getEmail());
			accountDto.setUsername(account.getUsername());
			accountDto.setFullname(account.getFullname());
			accountDto.setAvatarImageName(account.getAvatarImageName());
			accountDto.setMobile(account.getMobile());
			accountDto.setAddress(account.getAddress());
			accountDto.setCreateDate(account.getCreateDate());
			accountDto.setStatus(account.getStatus().toString());
			accountDtos.add(accountDto);
		}
		return new ResponseEntity<>(accountDtos, HttpStatus.OK);

	}

//Get Account By ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> GetAccountByID(@PathVariable(name = "id") short id) {
		try {
			Account account = accountService.GetAccountByID(id);
			// Chuyển đổi dữ liệu
			AccountDto accountDto = new AccountDto();
			accountDto.setId(account.getId());
			accountDto.setEmail(account.getEmail());
			accountDto.setUsername(account.getUsername());
			accountDto.setFullname(account.getFullname());
			accountDto.setAvatarImageName(account.getAvatarImageName());
			accountDto.setMobile(account.getMobile());
			accountDto.setAddress(account.getAddress());
			accountDto.setCreateDate(account.getCreateDate());
			accountDto.setStatus(account.getStatus().toString());
			return new ResponseEntity<>(accountDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}

// Thêm mới Account
	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating accountNewForm) {
		try {
			Account newAccount = accountService.createAccount(accountNewForm);
			// Chuyển đổi dữ liệu
			AccountDto accountDto = new AccountDto();
			accountDto.setId(newAccount.getId());
			accountDto.setEmail(newAccount.getEmail());
			accountDto.setUsername(newAccount.getUsername());
			accountDto.setFullname(newAccount.getFullname());
			accountDto.setAvatarImageName(newAccount.getAvatarImageName());
			accountDto.setMobile(newAccount.getMobile());
			accountDto.setAddress(newAccount.getAddress());
			accountDto.setCreateDate(newAccount.getCreateDate());
			accountDto.setStatus(newAccount.getStatus().toString());
			return new ResponseEntity<>(accountDto, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Not OK", HttpStatus.BAD_REQUEST);
		}
	}

// Update Account
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> UpdateAccount(@PathVariable(name = "id") short id,
			@RequestBody AccountFormForUpdating updateAccountForm) {
		try {
			Account updateAccount = accountService.UpdateAccount(id, updateAccountForm);
			// Chuyển đổi dữ liệu
			AccountDto accountDto = new AccountDto();
			accountDto.setId(updateAccount.getId());
			accountDto.setEmail(updateAccount.getEmail());
			accountDto.setUsername(updateAccount.getUsername());
			accountDto.setFullname(updateAccount.getFullname());
			accountDto.setAvatarImageName(updateAccount.getAvatarImageName());
			accountDto.setMobile(updateAccount.getMobile());
			accountDto.setAddress(updateAccount.getAddress());
			accountDto.setCreateDate(updateAccount.getCreateDate());
			accountDto.setStatus(updateAccount.getStatus().toString());

			return new ResponseEntity<>(accountDto, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}

	// DeleteAccount
	@DeleteMapping(value = "/{id}")
	private ResponseEntity<?> deleteAccount(@PathVariable(name = "id") short id) {
		try {
			Account deleteAccount = accountService.GetAccountByID(id);
//Chuyển đổi dữ liệu
			AccountDto deleteAccountDto = new AccountDto();
			deleteAccountDto.setId(deleteAccount.getId());
			deleteAccountDto.setEmail(deleteAccount.getEmail());
			deleteAccountDto.setUsername(deleteAccount.getUsername());
			deleteAccountDto.setFullname(deleteAccount.getFullname());
			deleteAccountDto.setAvatarImageName(deleteAccount.getAvatarImageName());
			deleteAccountDto.setMobile(deleteAccount.getMobile());
			deleteAccountDto.setAddress(deleteAccount.getAddress());
			deleteAccountDto.setCreateDate(deleteAccount.getCreateDate());
			deleteAccountDto.setStatus(deleteAccount.getStatus().toString());
			accountService.deleteAccount(id);

			return new ResponseEntity<>(deleteAccountDto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}
}
