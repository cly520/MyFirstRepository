package dao;

import model.*;

import java.util.List;
import java.util.Map;

public interface UserDao {
//    定义一个验证登录的方法
    public User getUser(String username , String password);
//    通过id返回地区集合
    public List<District> getDistrict();
//    通过用户名密码将用户插入数据库
    public int insertUser(String user , String pawd);
//    遍历user表
    public List<User> selectUser();
//    遍历学生信息表
    List<Emp> selectEmp(Map<String, Object> params);
//    定义一个查询学生信息条数的方法
    Integer countEmp(Map<String, Object> params);
//    将数据插入学生信息表中
    void insertEmp(Emp emp);
//    通过id查询学生信息
    Emp getId(int id);
//    修改学生信息
    void updateEmp(Emp emp);
//    删除学生信息
    void deleteEmp(int id);
//    遍历楼栋表信息
    List<Emp> selectLouDong(Map<String, Object> params);
//    定义一个查询楼栋信息条数的方法
    Integer countLouDong(Map<String, Object> params);
//    通过id查询楼栋信息
    List<LouDong> getLouDong();
//    将数据插入报修信息表中
    void insertBaoXiu(BaoXiu baoXiu);
//    遍历报修表信息
    List<BaoXiu> selectBaoXiu(Map<String, Object> params);
//    定义一个查询报修信息条数的方法
    Integer countBaoXiu(Map<String, Object> params);
}
