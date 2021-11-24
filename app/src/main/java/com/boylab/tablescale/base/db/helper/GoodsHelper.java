package com.boylab.tablescale.base.db.helper;

import com.boylab.tablescale.base.db.table.Goods;

import org.greenrobot.greendao.AbstractDao;

public class GoodsHelper extends DBHelper<Goods, Long>{
    public GoodsHelper(AbstractDao dao) {
        super(dao);
    }
}
