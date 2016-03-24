package tyky.web;

import com.alibaba.fastjson.JSON;
import entity.Pager;
import entity.Table;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tyky.service.UserService;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by Just on 2016/3/20.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("tolist")
    public String tolist() {
        return "demo";
    }

    @RequestMapping("list")
    @ResponseBody
    public String test(Pager pager, User user) {
        Table<User> t=userService.test(pager,user);

        return JSON.toJSONString(t);
    }

    /*@Transactional测试*/
    @RequestMapping("delete")
    public String deleteById(String id){
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            log.warn("@Transactional测试。。.deleteById("+id+")");
        }

        return "redirect:tolist";
    }

    @RequestMapping("deletebybatch")
    public String deleteByBatch(String[] array) {
        try {
            userService.deleteByBatch(array);
        } catch (Exception e) {
           log.warn("@Transactional测试。。.deletebybatch("+ Arrays.toString(array)+")");
        }

        return "redirect:tolist";
    }
    /*@Transactional测试*/


    /*测试AOP开始*/
    public String get(String name) {
            log.warn("getUser method . . .");

        return "hello,"+name;
    }

    public void save() {
            log.warn("saveUser method . . .");
    }

    public String delete(String name) throws Exception {
            log.warn("delete method . . .");

            throw new Exception("spring aop ThrowAdvice演示");
    }
    /*测试AOP结束*/

}
