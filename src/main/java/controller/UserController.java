package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 测试类
 */
@Controller
public class UserController {

    @RequestMapping(value = "user")
    public String userMessage(String name , int age ){
        System.out.println("---------------------"+name+"   "+age);
        return "main";
    }

    @RequestMapping("user2")
    public String user02(User user){
        System.out.println(user.getName()+"---"+user.getAge());
        return  "main";
    }

    @RequestMapping("user3")
    public String user03(@RequestParam("name") String username, @RequestParam("age") int userAge){
        System.out.println(username+"----"+userAge);
        return "main";
    }

    @RequestMapping("user5")
    public String  user05(@RequestParam(defaultValue = "22") String username, @RequestParam(required = false , defaultValue = "1") int userAge){
        System.out.println(username+" "+ userAge);
        return "main";
    }

    @RequestMapping("user4")
    public String user04 (User user , @RequestParam("like") List<String> list){
        System.out.println(user.getName()+" "+user.getAge());
        list.forEach(System.out::println);
        return "main";
    }

    @RequestMapping("user6/{name}/{age}")
    public String user06 (@PathVariable String name , @PathVariable int age){
        System.out.println(name+"  "+age);
        return "main";
    }

    @RequestMapping("user7")
    public String user7 (){
        return "forward:user8";
    }

    @RequestMapping("user8")
    public String user8(){
        System.out.println("------------");
        return "main";
    }

    @RequestMapping("user9")
    @ResponseBody
    public User user9(){
        System.out.println("1111111111");
        User user  = new User();
        user.setAge(1);
        user.setName("www");
        return  user;
    }

}
