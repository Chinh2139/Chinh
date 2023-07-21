package com.vti.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.Entity.Account;
import com.vti.Form.AccountFormForCreating;
import com.vti.Form.AccountFormForUpdating;
import com.vti.Repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account GetAccountByID(short id) {
		// TODO Auto-generated method stub
		return accountRepository.getById(id);
	}

	@Override
	public Account createAccount(AccountFormForCreating accountNewForm) {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setEmail(accountNewForm.getEmail());
		account.setUsername(accountNewForm.getUsername());
		account.setFullname(accountNewForm.getFullname());
		account.setAvatarImageName(accountNewForm.getAvatarImageName());
		account.setMobile(accountNewForm.getMobile());
		account.setAddress(accountNewForm.getAddress());
		account.setPassword(accountNewForm.getPassword());
		Account accountNew = accountRepository.save(account);
		return accountNew;
	}

	@Override
	public Account UpdateAccount(short id, AccountFormForUpdating updateAccountForm) {
		// TODO Auto-generated method stub
		Account account = accountRepository.getById(id);
		account.setFullname(updateAccountForm.getFullname());
		account.setAvatarImageName(updateAccountForm.getAvatarImageName());
		account.setMobile(updateAccountForm.getMobile());
		account.setAddress(updateAccountForm.getAddress());
		Account accountUpdate = accountRepository.save(account);
		return accountUpdate;
	}

	@Override
	public void deleteAccount(short id) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(id);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		@Override
//		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////			Tìm thông tin Account theo Username nhận được
//			Account account = accountRepository.findByUsername(username);
//
////			Kiểm tra xem có dữ liệu dưới DB?
//			if (account != null) {
//				return new User(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList("user"));
//
//			} else {
//				throw new UsernameNotFoundException(username);
//
//			}
//
//		}
}
