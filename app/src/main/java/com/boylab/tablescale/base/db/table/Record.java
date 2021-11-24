package com.boylab.tablescale.base.db.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Record extends BaseTable {
    @Id
    private long id;

    @Generated(hash = 689057537)
    public Record(long id) {
        this.id = id;
    }

    @Generated(hash = 477726293)
    public Record() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
