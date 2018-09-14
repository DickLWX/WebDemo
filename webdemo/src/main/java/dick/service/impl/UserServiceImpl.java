package dick.service.impl;

import java.util.UUID;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import dick.entity.User;
import dick.service.UserService;


@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    
    /**
     * 使用HASH函数加密密码
     * @param user
     * @return
     */
    public User encryptedPassword(User user) {
        String salt = UUID.randomUUID().toString();
        Md5Hash md5Hash = new Md5Hash(user.getUserPassword(), salt, 2);
        user.setUserPassword(md5Hash.toString());
        user.setSalt(salt);
        return user;
    }
}
