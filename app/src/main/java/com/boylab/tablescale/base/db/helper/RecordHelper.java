package com.boylab.tablescale.base.db.helper;

import com.boylab.tablescale.base.db.table.Record;

import org.greenrobot.greendao.AbstractDao;

public class RecordHelper extends DBHelper<Record, Long>{

    public RecordHelper(AbstractDao dao) {
        super(dao);
    }
}
