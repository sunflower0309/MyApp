package com.example.xlm.mydrawerdemo.Dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.xlm.mydrawerdemo.bean.ChildForm;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;



// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig childFormDaoConfig;

    private final ChildFormDao childFormDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        childFormDaoConfig = daoConfigMap.get(ChildFormDao.class).clone();
        childFormDaoConfig.initIdentityScope(type);

        childFormDao = new ChildFormDao(childFormDaoConfig, this);

        registerDao(ChildForm.class, childFormDao);
    }
    
    public void clear() {
        childFormDaoConfig.getIdentityScope().clear();
    }

    public ChildFormDao getChildFormDao() {
        return childFormDao;
    }

}