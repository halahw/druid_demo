package web;

import dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Just on 2016/3/20.
 */
@Controller
public class UserController {
    @Resource
    private UserDao userDao;

    @RequestMapping("findAll")
    public String test(ModelMap model){
       model.put("users", userDao.findAll());
        return "demo";
    }
}
