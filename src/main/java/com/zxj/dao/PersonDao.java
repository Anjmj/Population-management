package com.zxj.dao;

import com.zxj.model.po.TbPerson;
import com.zxj.model.vo.DataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonDao {
    /**
     * 分頁查詢
     * @param dataVo
     * @return
     */
    List<TbPerson> listPerson(DataVo dataVo);

    /**
     * 查詢數量
     * @return
     */
    int countPerson(@Param("pname") String pname);

    /**
     * 删除
     * @param id
     * @return
     */
    int removePerson(@Param(value = "pid") Integer id);

    /**
     * 添加
     * @param tbPerson
     * @return
     */
    int savePerson(TbPerson tbPerson);

    /**
     * 修改
     * @param tbPerson
     * @return
     */
    int updatePerson(TbPerson tbPerson);

    /**
     * 根据id查询person
     * @param pid
     * @return
     */
    TbPerson getPersonById(@Param(value = "pid") Integer pid);

}
