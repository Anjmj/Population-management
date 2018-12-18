package action;

import com.zxj.model.po.TbPerson;
import com.zxj.model.vo.PersonVo;
import com.zxj.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
    @RequestMapping("/admin")
    public String toAdmin(){
        return "admin";
    }
    @RequestMapping("/login")
    public String tologin(){
        return "login";
    }
    @ResponseBody
    @RequestMapping("/persons")
    public Map<String,Object> listPerson(@RequestParam(name = "page", defaultValue = "1") int currentPage
            ,@RequestParam(name = "limit", defaultValue = "10") int pageSize,@RequestParam(name = "key[pname]", defaultValue = "") String pname){
        /*Map<String,Object> map=new HashMap<>();
        map.put("id",1);
        map.put("username","张三");
        map.put("sex","男");
        map.put("city","北京");
        map.put("sign","时间吃客");
        map.put("experience","100");
        map.put("score",5);
        map.put("classify","球手");
        map.put("wealth",1000000);*/
        List<TbPerson> personList = personService.showPerson(currentPage, pageSize,pname);
        //獲得帶分頁數據的person數據
        //List<PersonVo> personVos = personService.showPersonVo(currentPage, pageSize);
        int count = personService.getCount(pname);
        Map<String,Object> map1=new HashMap<>();
        /*List<Object> list=new ArrayList<>();
        list.add(map);*/
        map1.put("code",0);
        map1.put("msg","1");
        map1.put("count",count);
        map1.put("data",personList);
        return map1;
    }
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Object deletePerson(String pid){

        int id = Integer.parseInt(pid);
        String s = personService.deletePerson(id);
        return s;
    }
    @RequestMapping("/toUpdate/{pid}")
    public String toUpdate(Model model, @PathVariable(value = "pid") String pid) {
        int id = Integer.parseInt(pid);
        TbPerson person = personService.getPerson(id);
        model.addAttribute("person",person);
        return "update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(TbPerson tbPerson){
        boolean flag = personService.update(tbPerson);
        if(flag){
            return "updateSuccess";
        }
        return "updateFail";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(TbPerson tbPerson){

        boolean flag = personService.add(tbPerson);
        if(flag){
            return "addSuccess";
        }

        return "addFail";
    }
}
