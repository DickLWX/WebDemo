package dick.control;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
        User user = userService.selectByPrimaryKey(id);
        System.out.println(user);
        return user;
    }
    
    /**
     * 用户注册：先对数据进行校验，再注册，发送邮件激活
     *
     * @param user          用户POJO
     * @param bindingResult 校验的结果
     * @return 重定向到页面
     * @throws Exception
     */
    @RequestMapping("/register.do")
    public String register(@Validated User user, BindingResult bindingResult) throws Exception {


        //如果参数不对，就直接返回注册页面
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (allErrors != null && allErrors.size() > 0) {
            return "redirect:/goURL/user/toRegister.do";
        }


        //对密码进行加密md5(密码+salt)后才存到数据库中
        userService.encryptedPassword(user);
        user.setUserId(new Date().getTime()+"");
        System.out.println("userid="+ user.getUserId());
        userService.insert(user);

        //提示用户发送了邮件，让用户激活账户
       // String url = getProjectPath() + "/user/activate.do?userId=" + user.getUserId();
       // emailService.sendEmail(user, "注册", url);
        System.out.println("插入数据成功了");
        return "redirect:/common/countDown.html";
    }
}
