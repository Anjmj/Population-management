package com.zxj.service;

import com.zxj.model.po.TbPerson;
import com.zxj.model.vo.PersonVo;

import java.util.List;

public interface PersonService {
    /**
     * 分页查询person
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<TbPerson> showPerson(int currentPage,int pageSize,String pname);

    /**
     * 分页查询带分页数据
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<PersonVo> showPersonVo(int currentPage,int pageSize,String name);

    /**
     * 获得总个数
     * @return
     */
    int getCount(String pid);

    /**
     * 根据id删除
     * @param pid
     * @return
     */
    String deletePerson(int pid);

    /**
     * 添加
     * @param tbPerson
     * @return
     */
    boolean add(TbPerson tbPerson);

    /**
     * 根据id查询person
     * @param id
     * @return
     */
    TbPerson getPerson(Integer id);
    boolean update(TbPerson tbPerson);
}
