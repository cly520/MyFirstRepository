package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.*;
import service.UserService;
import utils.Page;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User getUser(String username, String password) {
        User user = userDao.getUser(username, password);
        return user;
    }

    @Override
    public List<District> getDistrict() {
        List<District> list = userDao.getDistrict();
        return list;
    }

    @Override
    public boolean insertUser(String user, String pawd) {
        int a = userDao.insertUser(user, pawd);
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> selectUser() {
        List<User> list = userDao.selectUser();
        return list;
    }

    @Override
    public Page<Emp> selectEmp(Map<String, Object> params) {
//        分页查询的起点
        Integer start = (Integer.parseInt(params.get("pageCode").toString()) - 1) * Integer.parseInt(params.get("pageSize").toString());
//        分页查询的分页数
        Integer end = Integer.parseInt(params.get("pageSize").toString());
        params.put("start", start);
        params.put("end", end);
        List<Emp> list = userDao.selectEmp(params);
        Integer count = userDao.countEmp(params);
        Page<Emp> page = new Page<>();
        page.setBeanList(list);
        page.setTotalCount(count);
        page.setPageCode(Integer.parseInt(params.get("pageCode").toString()));
        page.setPageSize(Integer.parseInt(params.get("pageSize").toString()));
        return page;
    }

    @Override
    public void insertEmp(Emp emp) {
        if (emp.getId() == null) {
            userDao.insertEmp(emp);
        } else {
            userDao.updateEmp(emp);
        }
    }

    @Override
    public Emp getId(int id) {
        Emp emp = userDao.getId(id);
        return emp;
    }

    @Override
    public void deleteEmp(int id) {
        userDao.deleteEmp(id);
    }

    @Override
    public Page<Emp> selectLouDong(Map<String, Object> params) {
        //        分页查询的起点
        Integer start = (Integer.parseInt(params.get("pageCode").toString()) - 1) * Integer.parseInt(params.get("pageSize").toString());
//        分页查询的分页数
        Integer end = Integer.parseInt(params.get("pageSize").toString());
        params.put("start", start);
        params.put("end", end);
        List<Emp> list = userDao.selectLouDong(params);
        Integer count = userDao.countLouDong(params);
        Page<Emp> page = new Page<>();
        page.setBeanList(list);
        page.setTotalCount(count);
        page.setPageCode(Integer.parseInt(params.get("pageCode").toString()));
        page.setPageSize(Integer.parseInt(params.get("pageSize").toString()));
        return page;
    }

    @Override
    public List<LouDong> getLouDong() {
        List<LouDong> list = userDao.getLouDong();
        return list;
    }

    @Override
    public void insertBaoXiu(BaoXiu baoXiu) {
        userDao.insertBaoXiu(baoXiu);
    }

    @Override
    public Page<BaoXiu> selectBaoXiu(Map<String, Object> params) {
        //        分页查询的起点
        Integer start = (Integer.parseInt(params.get("pageCode").toString()) - 1) * Integer.parseInt(params.get("pageSize").toString());
//        分页查询的分页数
        Integer end = Integer.parseInt(params.get("pageSize").toString());
        params.put("start", start);
        params.put("end", end);
        List<BaoXiu> list = userDao.selectBaoXiu(params);
        Integer count = userDao.countBaoXiu(params);
        Page<BaoXiu> page = new Page<>();
        page.setBeanList(list);
        page.setTotalCount(count);
        page.setPageCode(Integer.parseInt(params.get("pageCode").toString()));
        page.setPageSize(Integer.parseInt(params.get("pageSize").toString()));
        return page;
    }
}

