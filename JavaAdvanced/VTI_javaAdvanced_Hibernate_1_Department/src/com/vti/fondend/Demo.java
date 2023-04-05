package com.vti.fondend;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Department;

public class Demo {
	public static void main(String[] args) {
// Tạo ra các session
		Session session = null;
		try {
			session = buildSessionFactory().openSession();
// Hiển thị danh sách phòng ban đang có trên hệ thống
			String hqlSelectDepartment = "FROM Department";
			Query<Department> query = session.createQuery(hqlSelectDepartment);

			List<Department> listDepartments = query.list();
			for (Department department : listDepartments) {
				System.out.println(department.toString());

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

// Hàm tạo ra SessionFactory sử dụng quản lý các session trong chương trình
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
// Đăng ký các đối tượng poji trong chương trình
		configuration.addAnnotatedClass(Department.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

}
