package model;

public class District {
    // 地区ID
    private Integer id;
    // 地区父ID
    private Integer pid;
    // 地区名称
    private String district;
    // 地区级别
    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public District() {

    }

    public District(Integer id, Integer pid, String district, Integer level) {

        this.id = id;
        this.pid = pid;
        this.district = district;
        this.level = level;
    }
}
