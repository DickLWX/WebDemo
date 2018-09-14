package dick.service;

import dick.entity.User;

public interface UserService extends BaseService<User>{
    
    /**
     * 对用户的密码进行加密
     * @param user
     * @return
     */
    User encryptedPassword(User user);
}
