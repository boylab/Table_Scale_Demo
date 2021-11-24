package com.boylab.tablescale.base.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User extends BaseTable {

    @Id
    private long id;

    private String userName;
    private String userPass;

    private int userPerm;
    private int weighPerm;
    private int scalePerm;
    private int otherPerm;

    @Generated(hash = 292199666)
    public User(long id, String userName, String userPass, int userPerm,
            int weighPerm, int scalePerm, int otherPerm) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
        this.userPerm = userPerm;
        this.weighPerm = weighPerm;
        this.scalePerm = scalePerm;
        this.otherPerm = otherPerm;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public int getUserPerm() {
        return userPerm;
    }

    public void setUserPerm(int userPerm) {
        this.userPerm = userPerm;
    }

    public int getWeighPerm() {
        return weighPerm;
    }

    public void setWeighPerm(int weighPerm) {
        this.weighPerm = weighPerm;
    }

    public int getScalePerm() {
        return scalePerm;
    }

    public void setScalePerm(int scalePerm) {
        this.scalePerm = scalePerm;
    }

    public int getOtherPerm() {
        return otherPerm;
    }

    public void setOtherPerm(int otherPerm) {
        this.otherPerm = otherPerm;
    }
}
