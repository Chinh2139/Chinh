package com.vti.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.Entity.Account;
import com.vti.Form.AccountFormForCreating;
import com.vti.Form.AccountFormForUpdating;
import com.vti.Repository.IAccountRepository;
import com.vti.specification.AccountSpecification;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public Account GetAccountByID(short id) {
		// TODO Auto-generated method stub
		return accountRepository.getById(id);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Tìm thông tin Account theo Username nhận được
		Account account = accountRepository.findByUsername(username);

//		Kiểm tra xem có dữ liệu dưới DB?
		if (account != null) {
			return new User(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList("user"));

		} else {
			throw new UsernameNotFoundException(username);

		}
	}

	@Override
	public Account getAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username);
	}

	@Override
	public Page<Account> getAllAccount(Pageable pageable, String search) {
		// TODO Auto-generated method stub
		Specification<Account> where = null;
		AccountSpecification usernameSpecification = new AccountSpecification("username", "LIKE", search);
		where = Specification.where(usernameSpecification);
		Page<Account> AccountPage = accountRepository.findAll(where, pageable);
		return AccountPage;
	}

	@Override
	public Account createAccountNewRegister(AccountFormForCreating accountNewRegisterForm) {
//			Tạo account cần thêm mới từ thông tin nhận được accountNewForm
		Account account = new Account();
		account.setEmail(accountNewRegisterForm.getEmail());
		account.setUsername(accountNewRegisterForm.getUsername());
		account.setFullname(accountNewRegisterForm.getFullname());
		account.setAvatarImageName(accountNewRegisterForm.getAvatarImageName());
		account.setMobile(accountNewRegisterForm.getMobile());
		account.setAddress(accountNewRegisterForm.getAddress());
//			Thực hiện mã hóa password trước khi lưu trữ
		String passEncode = passwordEncoder.encode(accountNewRegisterForm.getPassword());
		account.setPassword(passEncode);

		Account accountNew = accountRepository.save(account);
		return accountNew;
	}

}
