package com.boylab.tablescale.base.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Goods extends BaseTable {

    @Id
    private long id;

    @Generated(hash = 1131044887)
    public Goods(long id) {
        this.id = id;
    }

    @Generated(hash = 1770709345)
    public Goods() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
