<<<<<<< HEAD
package printer.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import printer.Model.UserModel;
import printer.UserDao.UserModelDao;

@Service
public class UserModelService {

	@Autowired
	private UserModelDao userModelDao;
	
	
	public int createUserModel(UserModel userModel) {
		return this.userModelDao.saveUserModel(userModel);
	}
	
}
=======
package printer.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import printer.Model.UserModel;
import printer.UserDao.UserModelDao;

@Service
public class UserModelService {

	@Autowired
	private UserModelDao userModelDao;
	
	
	public int createUserModel(UserModel userModel) {
		return this.userModelDao.saveUserModel(userModel);
	}
	
}
>>>>>>> 8bc82d02ee0c67f4eda06e02c2787e08d3e68e66
