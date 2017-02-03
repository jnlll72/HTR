package Project.Service;

import Project.DAO.UserDAO;
import Project.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public long add(User user) {
        return userDAO.add(user);
    }

    @Override
    public User getByEmailPwd(String email, String pwd) {
        return userDAO.getByEmailPwd(email, pwd);
    }
}
