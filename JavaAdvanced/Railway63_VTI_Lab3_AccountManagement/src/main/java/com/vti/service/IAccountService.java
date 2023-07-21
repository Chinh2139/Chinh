package com.vti.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFromForupdating;

public interface IAccountService extends UserDetailsService {

	public Page<Account> getAllAccount(Pageable pageable);

	public void createAccount(AccountFormForCreating form);

	public Account GetAccountByID(short id);

	public void updateAccount(short id, AccountFromForupdating form);

	public void DeleteAccount(short id);

//	public <Account> getAllAccount();

	Account getAccountByUsername(String username);

}
