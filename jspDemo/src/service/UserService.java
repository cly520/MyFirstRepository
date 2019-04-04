package service;

import model.*;
import utils.Page;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User getUser(String username , String password);

    public List<District> getDistrict();

    public boolean insertUser(String user , String pawd);

    public List<User> selectUser();

    Page<Emp> selectEmp(Map<String , Object> params);

    void insertEmp(Emp emp);

    Emp getId(int id);

    void deleteEmp(int id);

    Page<Emp> selectLouDong(Map<String, Object> params);

    List<LouDong> getLouDong();

    void insertBaoXiu(BaoXiu baoXiu);

    Page<BaoXiu> selectBaoXiu(Map<String, Object> params);
}
