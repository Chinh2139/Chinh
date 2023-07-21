package com.vti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.Entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Short> {
	public Account findByUsername(String username);
}
