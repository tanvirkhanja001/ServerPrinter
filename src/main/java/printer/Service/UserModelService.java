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
