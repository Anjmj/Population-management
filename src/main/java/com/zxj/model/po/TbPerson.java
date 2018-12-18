package com.zxj.model.po;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.sql.Date;


/**
 * `pid` int(11) NOT NULL AUTO_INCREMENT,
 *   `pname` varchar(32) NOT NULL,
 *   `pno` char(18) NOT NULL,
 *   `page` tinyint(4) NOT NULL,
 *   `pgender` varchar(8) NOT NULL,
 *   `paddress` varchar(128) DEFAULT NULL,
 *   `pphone` varchar(12) DEFAULT NULL,
 *   `pphoto` varchar(128) DEFAULT NULL,
 *   `pbirthday` date DEFAULT NULL,
 */
public class TbPerson {
    private Integer pid;
    private String pname;
    private String pno;
    private Integer page;
    private String pgender;
    private String paddress;
    private String pphone;
    private String pphoto;
    private Date pbirthday;

    public TbPerson() {
    }

    public Integer getPid() {

        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    @Override
    public String toString() {
        return "TbPerson{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pno='" + pno + '\'' +
                ", page=" + page +
                ", pgender='" + pgender + '\'' +
                ", paddress='" + paddress + '\'' +
                ", pphone='" + pphone + '\'' +
                ", pphoto='" + pphoto + '\'' +
                ", pbirthday=" + pbirthday +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getPgender() {
        return pgender;
    }

    public void setPgender(String pgender) {
        this.pgender = pgender;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public String getPphoto() {
        return pphoto;
    }

    public void setPphoto(String pphoto) {
        this.pphoto = pphoto;
    }

    public Date getPbirthday() {
        return pbirthday;
    }

    public void setPbirthday(Date pbirthday) {
        this.pbirthday = pbirthday;
    }
}
