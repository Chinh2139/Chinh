package com.vti.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.Entity.Account;
import com.vti.Form.AccountFormForCreating;
import com.vti.Form.AccountFormForUpdating;

public interface IAccountService extends UserDetailsService {

	public Page<Account> getAllAccount(Pageable pageable, String search);

	Account getAccountByUsername(String username);

	public Account GetAccountByID(short id);

	public Account createAccount(AccountFormForCreating accountNewForm);

	public Account UpdateAccount(short id, AccountFormForUpdating updateAccountForm);

	public void deleteAccount(short id);

	public Account createAccountNewRegister(AccountFormForCreating accountNewRegisterForm);

}
