package model;

public class BaoXiu {
    private int id;
    private String ename;
    private int sex;
    private int loudongId;
    private String baoxiu;
    private LouDong louDong;

    public LouDong getLouDong() {
        return louDong;
    }

    public void setLouDong(LouDong louDong) {
        this.louDong = louDong;
    }

    public BaoXiu(int id, String ename, int sex, int loudongId, String baoxiu, LouDong louDong) {
        this.id = id;
        this.ename = ename;
        this.sex = sex;
        this.loudongId = loudongId;
        this.baoxiu = baoxiu;
        this.louDong = louDong;
    }

    public BaoXiu(int id, String ename, int sex, int loudongId, String baoxiu) {
        this.id = id;
        this.ename = ename;
        this.sex = sex;
        this.loudongId = loudongId;
        this.baoxiu = baoxiu;
    }

    public BaoXiu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getLoudongId() {
        return loudongId;
    }

    public void setLoudongId(int loudongId) {
        this.loudongId = loudongId;
    }

    public String getBaoxiu() {
        return baoxiu;
    }

    public void setBaoxiu(String baoxiu) {
        this.baoxiu = baoxiu;
    }
}
