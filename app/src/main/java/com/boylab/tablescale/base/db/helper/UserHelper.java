package com.boylab.tablescale.base.db.helper;

import com.boylab.tablescale.base.db.table.User;

import org.greenrobot.greendao.AbstractDao;

public class UserHelper extends DBHelper<User, Long>{
    public UserHelper(AbstractDao dao) {
        super(dao);
    }
}
