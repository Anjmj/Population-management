package com.zxj.service.impl;

import com.zxj.dao.PersonDao;
import com.zxj.model.po.TbPerson;
import com.zxj.model.vo.DataVo;
import com.zxj.model.vo.PersonVo;
import com.zxj.service.PersonService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    @Override
    public List<TbPerson> showPerson(int currentPage, int pageSize,String pname) {
        int offset = (currentPage - 1) * pageSize;
        DataVo dataVo = new DataVo();
        dataVo.setOffset(offset);
        dataVo.setPageSize(pageSize);
        dataVo.setPname(pname);
        List<TbPerson> list = personDao.listPerson(dataVo);
        return list;
    }

    @Override
    public List<PersonVo> showPersonVo(int currentPage, int pageSize,String pname) {
        int offset = (currentPage - 1) * pageSize;
        DataVo dataVo = new DataVo();
        dataVo.setOffset(offset);
        dataVo.setPageSize(pageSize);
        dataVo.setPname(pname);
        int count = personDao.countPerson(pname);
        List<TbPerson> list = personDao.listPerson(dataVo);
        ListIterator<TbPerson> it = list.listIterator();
        List<PersonVo> listVo=new ArrayList<>();
        while (it.hasNext()){
            TbPerson person = it.next();
            try {
                PersonVo pv=new PersonVo();
                BeanUtils.copyProperties(pv,person);
                pv.setCount(count);
                pv.setPage(currentPage);
                pv.setLimit(pageSize);
                listVo.add(pv);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return listVo;
    }

    @Override
    public int getCount(String pname) {
        return personDao.countPerson(pname);
    }

    @Override
    public String deletePerson(int pid) {
        int i = personDao.removePerson(pid);
        String str=null;
        if(i==1){
            str="删除成功";
        }else {
            str="删除失败";
        }

        return str;
    }

    @Override
    public boolean add(TbPerson tbPerson) {
        int i = personDao.savePerson(tbPerson);
        if(i==1){
            return true;
        }
        return false;
    }

    @Override
    public TbPerson getPerson(Integer id) {
        return personDao.getPersonById(id);
    }

    @Override
    public boolean update(TbPerson tbPerson) {
        return personDao.updatePerson(tbPerson)==1;
    }
}
