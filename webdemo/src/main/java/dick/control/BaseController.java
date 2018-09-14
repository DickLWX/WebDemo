package dick.control;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dick.service.UserService;

@Controller
public class BaseController {
    
    @Autowired
    protected UserService userService;
    
    /**
     * 通用的跳转页面的方法
     *
     * @param folder 文件夹
     * @param file   具体文件
     * @return 具体的页面
     */
    @RequestMapping("/goURL/{folder}/{file}.do")
    public String goURL(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        return "jsp"+"/"+folder+"/"+file;
    }
}
