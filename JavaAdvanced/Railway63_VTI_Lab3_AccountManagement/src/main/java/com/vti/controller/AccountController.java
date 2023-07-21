package com.vti.controller;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.vti.dto.AccountDto;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFromForupdating;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "ap1/v1/RequestToAccount")
@CrossOrigin("*")
public class AccountController {
	@Autowired
	private IAccountService accountService;

	@GetMapping
	public ResponseEntity<?> getAllAccount(Pageable pageable) {
		Page<Account> listAccounts = accountService.getAllAccount(pageable);
		System.out.println("pageable : " + pageable);
//		List<AccountDto> accountDtos = new ArrayList<>();

//		for (Account account : listAccounts) {
//			System.out.println(listAccounts);
//		}
		// Chuyển đổi dữ liệu
//		List<AccountDto> listAccountDtos = new ArrayList<>();
		Page<AccountDto> dtoPage = listAccounts.map(new Function<Account, AccountDto>() {

			@Override
			public AccountDto apply(Account account) {
				AccountDto accountDto = new AccountDto();
				accountDto.setId(account.getId());
				accountDto.setUsername(account.getUsername());
				accountDto.setFullname(account.getFullname());
				accountDto.setEmail(account.getEmail());
				accountDto.setDepartment(account.getDepartment().getName());
				accountDto.setPosition(account.getPosition().toString());
				accountDto.setCreateDate(account.getCreateDate());
//		listAccountDtos.add(accountDto);
				return accountDto;
			}
		});
//		for (Account account : listAccounts) {
//			AccountDto accountDto = new AccountDto();
//			accountDto.setId(account.getId());
//			accountDto.setUsername(account.getUsername());
//			accountDto.setFullname(account.getFullname());
//			accountDto.setEmail(account.getEmail());
//			accountDto.setDepartment(account.getDepartment().getName());
//			accountDto.setPosition(account.getPosition().toString());
//			accountDto.setCreateDate(account.getCreateDate());
//			listAccountDtos.add(accountDto);
//
//		}
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	// lấy Account theo ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> GetAccountByID(@PathVariable(name = "id") short id) {
		Account account = accountService.GetAccountByID(id);
		AccountDto accountDto = new AccountDto(account.getId(), account.getEmail(), account.getUsername(),
				account.getFullname(), account.getDepartment().getName(), account.getPosition().getName().toString(),
				account.getCreateDate());

		return new ResponseEntity<>(accountDto, HttpStatus.OK);
	}

	// Tạo Account mới
	@PostMapping
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form) {
//		System.out.println(departmentFormForCreating.getName());
		accountService.createAccount(form);

		// chuyển đổi kiểu dữ liệu
//		AccountDto accountDto = new AccountDto();
//		accountDto.setEmail(account.getEmail());

		return new ResponseEntity<String>("create successfully", HttpStatus.CREATED);
	}

	// Update Account ByID
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> UpdateAccount(@PathVariable(name = "id") short id,
			@RequestBody AccountFromForupdating form) {
		accountService.updateAccount(id, form);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);

	}

	// Delete Account
	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> DeleteAccount(@PathVariable(name = "id") short id) {
		accountService.DeleteAccount(id);
		return new ResponseEntity<String>("Delete Account Successfully", HttpStatus.OK);
	}
}
