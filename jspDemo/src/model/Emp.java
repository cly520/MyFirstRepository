package model;

import java.io.Serializable;
import java.util.Date;


public class Emp implements Serializable {

    // 主键
    private Integer id;
    // 学生姓名
    private String ename;
    // 年龄
    private Integer age;
    // 性别
    private Integer sex;
    // 学费
    private Double sal;
    // 生日
    private Date birthday;
    // 入校日期
    private Date edate;
    // 地区
    private District district;
    // 地区ID
    private Integer districtId;
//    楼栋
    private LouDong louDong;
//    楼栋ID
    private Integer loudongId;

    public LouDong getLouDong() {
        return louDong;
    }

    public void setLouDong(LouDong louDong) {
        this.louDong = louDong;
    }

    public Integer getLoudongId() {
        return loudongId;
    }

    public void setLoudongId(Integer loudongId) {
        this.loudongId = loudongId;
    }

    public Emp(Integer id, String ename, Integer age, Integer sex, Double sal, Date birthday, Date edate, int districtId, int loudongId, LouDong louDong) {
        this.id = id;
        this.ename = ename;
        this.age = age;
        this.sex = sex;
        this.sal = sal;
        this.birthday = birthday;
        this.edate = edate;
        this.louDong = louDong;
        this.loudongId = loudongId;
    }

    public Emp(Integer id, String ename, Integer age, Integer sex, Double sal, Date birthday, Date edate, Integer districtId,Integer loudongId , District district) {
        this.id = id;
        this.ename = ename;
        this.age = age;
        this.sex = sex;
        this.sal = sal;
        this.birthday = birthday;
        this.edate = edate;
        this.districtId = districtId;
        this.district = district;
    }

    public Emp(Integer id, String ename, Integer age, Integer sex, Double sal, Date birthday, Date edate, Integer districtId, Integer loudongId) {
        this.id = id;
        this.ename = ename;
        this.age = age;
        this.sex = sex;
        this.sal = sal;
        this.birthday = birthday;
        this.edate = edate;
        this.districtId = districtId;
        this.loudongId = loudongId;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Emp() {
    }

    public Emp(Integer id, String ename, Integer age, Integer sex, Double sal, Date birthday, Date edate, District district, Integer districtId) {
        this.id = id;
        this.ename = ename;
        this.age = age;
        this.sex = sex;
        this.sal = sal;
        this.birthday = birthday;
        this.edate = edate;
        this.district = district;
        this.districtId = districtId;
    }

    public Emp(Integer id, String ename, Integer age, Integer sex, Double sal, Date birthday, Date edate, Integer districtId) {
        this.id = id;
        this.ename = ename;
        this.age = age;
        this.sex = sex;
        this.sal = sal;
        this.birthday = birthday;
        this.edate = edate;
        this.districtId = districtId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }
}
