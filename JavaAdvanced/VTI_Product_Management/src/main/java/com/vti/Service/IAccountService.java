package com.vti.Service;

import java.util.List;

import com.vti.Entity.Account;
import com.vti.Form.AccountFormForCreating;
import com.vti.Form.AccountFormForUpdating;

public interface IAccountService {

	public List<Account> getAllAccount();

	public Account GetAccountByID(short id);

	public Account createAccount(AccountFormForCreating accountNewForm);

	public Account UpdateAccount(short id, AccountFormForUpdating updateAccountForm);

	public void deleteAccount(short id);

}
