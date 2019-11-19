package com.senac.pedro.gunregister.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import com.senac.pedro.gunregister.model.Armamento;
import com.senac.pedro.gunregister.model.Conta;

public class  ORMLiteHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "gun.db";
    private static final int DATABASE_VERSION = 1;
    private static ORMLiteHelper mInstance = null;

    public ORMLiteHelper(Context c){
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Armamento.class);
            TableUtils.createTable(connectionSource, Conta.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Armamento.class, true);
            TableUtils.dropTable(connectionSource, Conta.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
