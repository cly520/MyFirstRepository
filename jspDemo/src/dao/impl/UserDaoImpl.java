package dao.impl;

import com.sun.org.apache.regexp.internal.RE;
import dao.UserDao;
import jdk.nashorn.internal.scripts.JD;
import model.*;
import utils.JdbcUtils;

import javax.print.attribute.standard.Fidelity;
import java.sql.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String username, String password) {
        Connection conn = null ;
        PreparedStatement stmt = null ;
        ResultSet rs = null ;
        User user = null ;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_user where username =? and password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs = stmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                String nickname = rs.getString("nickname");
                user = new User(id,username,password,nickname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return user;
    }

    @Override
    public List<District> getDistrict() {
       List<District> list = new ArrayList<>() ;
        Connection conn = null ;
        PreparedStatement stmt = null ;
        ResultSet rs = null ;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_district where LEVEL =1";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id1 = rs.getInt("id");
                int pid = rs.getInt("pid");
                String district1 = rs.getString("district");
                int level = rs.getInt("level");
                District district = new District(id1,pid,district1,level);
                list.add(district);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return list;
    }

    @Override
    public int insertUser(String user, String pawd) {
        Connection conn = null ;
        PreparedStatement stmt = null ;
        int result = 0;
        try {
//            通过工具类JdbcUtils获得驱动连接
            conn = JdbcUtils.getConnection();
//            编写sql语句
            String sql = "insert into t_user values(null,?,?,?)";
//            预编译sql语句
            stmt = conn.prepareStatement(sql);
//            给占位符赋值
            stmt.setString(1,user);
            stmt.setString(2,pawd);
            stmt.setString(3,user);
//            执行
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn ,stmt);
        }
        return result;
    }

    @Override
    public List<User> selectUser() {
        List<User> list = new ArrayList<>();
        Connection conn = null ;
        PreparedStatement stmt = null ;
        ResultSet rs = null ;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_user";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                User user = new User(id,username,password,nickname);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn , stmt , rs );
        }

        return list;
    }
    //        分页查询数据
    @Override
    public List<Emp> selectEmp(Map<String, Object> params) {
        Connection conn = null ;
        List<Emp> list = new ArrayList<>();
        PreparedStatement stmt = null ;
        ResultSet rs = null ;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_emp e LEFT join t_district d ON e.districtid=d.id WHERE 1=1";
            if(params.get("ename") != null && !params.get("ename").equals("")){
                sql += " and e.ename like '%"+params.get("ename")+"%'";
            }
            if(params.get("district") != null && !params.get("district").equals("")){
                sql += " and e.districtid=" + params.get("district");
            }
//        分页查询
            sql += " LIMIT ?,?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,Integer.parseInt(params.get("start").toString()));
            stmt.setInt(2,Integer.parseInt(params.get("end").toString()));
            rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String ename = rs.getString(2);
                int age = rs.getInt(3);
                int sex = rs.getInt(4);
                double sal = rs.getDouble(5);
                Date birthday = rs.getDate(6);
                Date edate = rs.getDate(7);
                int districtId = rs.getInt(8);
                int loudongId = rs.getInt(9);
                int id2 = rs.getInt(10);
                int pid = rs.getInt(11);
                String district = rs.getString(12);
                int level = rs.getInt(13);
                District district1 = new District(id2,pid,district,level);
                Emp emp = new Emp(id,ename,age,sex,sal,birthday,edate,districtId,loudongId,district1);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return list;
    }

    @Override
    public Integer countEmp(Map<String, Object> params) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer count = 0;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT count(*) FROM t_emp e where 1=1 ";

            // 通过判断前台传递的参数  拼接sql
            if(params.get("ename") != null && !params.get("ename").equals("")){
                sql += " and e.ename like '%"+params.get("ename")+"%'";
            }
            if(params.get("district") != null && !params.get("district").equals("")){
                sql += " and e.districtid=" + params.get("district");
            }
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()){
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return count;
    }

    @Override
    public void insertEmp(Emp emp) {
        Connection conn = null ;
        PreparedStatement stmt = null ;
        try {
            conn= JdbcUtils.getConnection();
            String sql = "insert into t_emp values(null,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,emp.getEname());
            stmt.setInt(2,emp.getAge());
            stmt.setInt(3,emp.getSex());
            stmt.setDouble(4,emp.getSal());
            stmt.setDate(5,new Date(emp.getBirthday().getTime()));
            stmt.setDate(6,new Date(emp.getEdate().getTime()));
            stmt.setInt(7,emp.getDistrictId());
            stmt.setInt(8,emp.getLoudongId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt);
        }
    }

    @Override
    public Emp getId(int id) {
        Connection conn = null ;
        PreparedStatement stmt = null ;
        ResultSet rs= null ;
        Emp emp = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_emp where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            if(rs.next()){
                emp = new Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),
                        rs.getInt(4),rs.getDouble(5),rs.getDate(6),
                        rs.getDate(7),rs.getInt(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return emp;
    }

    @Override
    public void updateEmp(Emp emp) {
        Connection conn = null ;
        PreparedStatement stmt = null ;
        try {
            conn= JdbcUtils.getConnection();
            String sql = "UPDATE t_emp SET ename = ? , age = ? , sex = ? , sal = ? , birthday = ? , edate = ? , districtid = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,emp.getEname());
            stmt.setInt(2,emp.getAge());
            stmt.setInt(3,emp.getSex());
            stmt.setDouble(4,emp.getSal());
            stmt.setDate(5,new Date(emp.getBirthday().getTime()));
            stmt.setDate(6,new Date(emp.getEdate().getTime()));
            stmt.setInt(7,emp.getDistrictId());
            stmt.setInt(8,emp.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt);
        }
    }

    @Override
    public void deleteEmp(int id) {
        Connection conn = null ;
        PreparedStatement stmt = null ;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from t_emp where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn ,stmt);
        }
    }

    @Override
    public List<Emp> selectLouDong(Map<String, Object> params) {
        Connection conn = null ;
        List<Emp> list = new ArrayList<>();
        PreparedStatement stmt = null ;
        ResultSet rs = null ;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_emp e LEFT join t_loudong l ON e.loudongid=l.id WHERE 1=1";
            if(params.get("ename") != null && !params.get("ename").equals("")){
                sql += " and e.ename like '%"+params.get("ename")+"%'";
            }
            if(params.get("loudong") != null && !params.get("loudong").equals("")){
                sql += " and e.loudongid=" + params.get("loudong");
            }
//        分页查询
            sql += " LIMIT ?,?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,Integer.parseInt(params.get("start").toString()));
            stmt.setInt(2,Integer.parseInt(params.get("end").toString()));
            rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String ename = rs.getString(2);
                int age = rs.getInt(3);
                int sex = rs.getInt(4);
                double sal = rs.getDouble(5);
                Date birthday = rs.getDate(6);
                Date edate = rs.getDate(7);
                int districtId = rs.getInt(8);
                int loudongId = rs.getInt(9);
                int id2 = rs.getInt(10);
                int fid = rs.getInt(11);
                LouDong louDong = new LouDong(id2,fid);
                Emp emp = new Emp(id,ename,age,sex,sal,birthday,edate,districtId,loudongId,louDong);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return list;
    }

    @Override
    public Integer countLouDong(Map<String, Object> params) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer count = 0;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT count(*) FROM t_emp e where 1=1 ";

            // 通过判断前台传递的参数  拼接sql
            if(params.get("ename") != null && !params.get("ename").equals("")){
                sql += " and e.ename like '%"+params.get("ename")+"%'";
            }
            if(params.get("loudong") != null && !params.get("loudong").equals("")){
                sql += " and e.loudongid=" + params.get("loudong");
            }
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()){
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return count;
    }

    @Override
    public List<LouDong> getLouDong() {
        List<LouDong> list = new ArrayList<>() ;
        Connection conn = null ;
        PreparedStatement stmt = null ;
        ResultSet rs = null ;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_loudong";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id1 = rs.getInt("id");
                int fid = rs.getInt("fid");
                LouDong louDong = new LouDong(id1,fid);
                list.add(louDong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return list;
    }

    @Override
    public void insertBaoXiu(BaoXiu baoXiu) {
        Connection conn = null ;
        PreparedStatement stmt = null ;
        try {
            conn= JdbcUtils.getConnection();
            String sql = "insert into t_baoxiu values(null,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,baoXiu.getEname());
            stmt.setInt(2,baoXiu.getSex());
            stmt.setInt(3,baoXiu.getLoudongId());
            stmt.setString(4,baoXiu.getBaoxiu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt);
        }
    }

    @Override
    public List<BaoXiu> selectBaoXiu(Map<String, Object> params) {
        Connection conn = null;
        List<BaoXiu> list = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_baoxiu b LEFT join t_loudong l ON b.loudongid=l.id WHERE 1=1";
            if (params.get("ename") != null && !params.get("ename").equals("")) {
                sql += " and b.ename like '%" + params.get("ename") + "%'";
            }
            if (params.get("loudong") != null && !params.get("loudong").equals("")) {
                sql += " and b.loudongid=" + params.get("loudong");
            }
//        分页查询
            sql += " LIMIT ?,?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(params.get("start").toString()));
            stmt.setInt(2, Integer.parseInt(params.get("end").toString()));
            rs = stmt.executeQuery();
            while (rs.next()) {
                BaoXiu baoXiu = new BaoXiu(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),new LouDong(rs.getInt(6),rs.getInt(7)));
                list.add(baoXiu);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return list;
    }

    @Override
    public Integer countBaoXiu(Map<String, Object> params) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer count = 0;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "SELECT count(*) FROM t_baoxiu b where 1=1 ";

            // 通过判断前台传递的参数  拼接sql
            if(params.get("ename") != null && !params.get("ename").equals("")){
                sql += " and b.ename like '%"+params.get("ename")+"%'";
            }
            if(params.get("loudong") != null && !params.get("loudong").equals("")){
                sql += " and b.loudongid=" + params.get("loudong");
            }
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()){
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,stmt,rs);
        }
        return count;
    }
}
