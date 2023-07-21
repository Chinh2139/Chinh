package com.vti.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountDAO {
	private HibernateUtils hibernateUtils = HibernateUtils.getInstance();;

//	public AccountDAO() {
//		hibernateUtils = HibernateUtils.getInstance();
//	}

//	Hàm GetAllAccount
	public List<Account> getAllAccount() {
		System.out.println("danh sach tat ca account la ");

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountByID(short idFind) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			Account account = session.get(Account.class, idFind);
			return account;
		} finally {
			// TODO: handle finally clause
			if (session != null) {
				session.close();
			}

		}
	}

	public void CreateAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			if (session != null) {
				session.close();
			}
		}
	}

	public String getFullnameById(short id) {
		Session session = null;
		try {
			// get session
			// SQL SELECT Fullname From Account Where = id;
			session = hibernateUtils.openSession();
			// create hql query
			String hqlSelectFullnameString = "SELECT a.fullname FROM Account AS a WHERE a.id= :idParam";
			Query<String> query = session.createQuery(hqlSelectFullnameString);
			query.setParameter("idParam", id);
			String fullnamefindString = query.uniqueResult();
			return fullnamefindString;

		} finally {
			if (session != null) {
				session.close();

			}

		}

	}

	public List<Account> getAllAccountCreateMonthNow() {
		Session session = null;

		try {
			session = hibernateUtils.openSession();
			// sql = SELECT * FROM account
			// WHERE month(createdate)=month(now()) AND year(createdate)=year(now())
			// ORDER BY CreateDate DESC;
			// chuyển đổi thành hql
			String hqlselectString = "FROM Account a WHERE month(a.createDate)=month(sysDate()) AND year(a.createDate)=year(sysDate()) ORDER BY a.createDate DESC;";
			Query<Account> query = session.createQuery(hqlselectString);
			return query.list();
		} finally {
			if (session != null) {
				session.close();

			}
		}

	}

}
