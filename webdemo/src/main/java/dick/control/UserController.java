package dick.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dick.entity.User;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    
    @RequestMapping(value="/getById.do",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getById(String id) {
        User user = UserService.selectByPrimaryKey(id);
        System.out.println(user);
        return user;
    }
}
