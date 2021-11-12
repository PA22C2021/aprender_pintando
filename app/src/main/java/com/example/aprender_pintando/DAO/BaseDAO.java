package com.example.aprender_pintando.DAO;

import android.content.Context;

public class BaseDAO {
    protected Context _context;
    protected static final String dbName = "aprender_pintando";
    protected static final int version = 1;

    public BaseDAO(Context _context){
        this._context = _context;
    }
}
