package web;

import com.alibaba.fastjson.JSON;
import dao.UserDao;
import entity.Pager;
import entity.Table;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Just on 2016/3/20.
 */
@Controller
public class UserController {
    @Resource
    private UserDao userDao;

    @RequestMapping("tolist.do")
    public String tolist(){
        return "demo";
    }

    @RequestMapping("list.do")
    @ResponseBody
    public String test(Pager pager, User user){
        if(pager==null){
            return null;
        }

        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("pager", pager);
        queryMap.put("user", user);

        List<User> list = userDao.findAll(queryMap);
        int total = userDao.countAll();

        Table<User> t = new Table<User>();
        t.setTotal(total);
        t.setRows(list);


        return JSON.toJSONString(t);
    }

    @RequestMapping("deletebybatch.do")
    public String deleteByBatch(String[] array){
        int[] ids=new int[array.length];
        for(int i=0;i<array.length;i++){
            ids[i]=Integer.parseInt(array[i]);
        }

        userDao.deleteByBatch(ids);

        return "redirect:tolist.do";
    }

}
