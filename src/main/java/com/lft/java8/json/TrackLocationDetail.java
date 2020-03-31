package com.lft.java8.json;

/**
 * 描述
 * @author Ryze
 * @date 2020-02-26 10:29
 */
public class TrackLocationDetail {
    /**
     * lx : 定位经度
     * ly : 定位纬度
     * x : 高德经度
     * y : 高德纬度
     * sp : 速度
     * ag : 方向角度
     * tm : 时间
     */
    private String lx;
    private String ly;
    private String x;
    private String y;
    private String sp;
    private String ag;
    private Long tm;

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getAg() {
        return ag;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public Long getTm() {
        return tm;
    }

    public void setTm(Long tm) {
        this.tm = tm;
    }
}
