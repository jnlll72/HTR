package Project.Service;

import Project.Model.User;

public interface UserService {
    public long add(User user);
    public User getByEmailPwd(String email, String pwd);
}
