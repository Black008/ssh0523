package cn.com.zhirun.ssh0507.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.com.zhirun.ssh0507.model.Member;

public class MemberDao {
	
	SessionFactory sessionFactory;
	public List<Member> selectMember(String name){
		
		/*Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();*/
		Session session=sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Member where name like "
				+ ":name");
		q.setParameter("name", "%"+name+"%");
		
		List<Member> memberList = q.list();
		/*transaction.commit();
		session.close();*/
		return memberList;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
