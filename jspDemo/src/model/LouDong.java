package model;

public class LouDong {
    private int id;
    private  int fid;

    public LouDong(int id, int fid) {
        this.id = id;
        this.fid = fid;
    }

    public LouDong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
}
