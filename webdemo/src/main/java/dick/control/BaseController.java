package dick.control;

import org.springframework.beans.factory.annotation.Autowired;

import dick.service.UserService;

public class BaseController {
    
    @Autowired
    protected UserService UserService;
}
