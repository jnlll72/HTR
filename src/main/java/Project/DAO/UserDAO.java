package Project.DAO;

import Project.Model.User;

public interface UserDAO {
    public Long add(User user);
    public User getByEmailPwd(String email, String pwd);
}
