package printer.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import printer.Model.UserModel;

@Repository
public class UserModelDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveUserModel(UserModel userModel) {
		int id = (Integer) this.hibernateTemplate.save(userModel);
		return id;
	}
}
