package com.senac.pedro.gunregister.dao;

import com.j256.ormlite.dao.Dao;
import com.senac.pedro.gunregister.model.Conta;

import java.sql.SQLException;

public class ContaDao {

    private Dao<Conta, Integer> contaDao;
    private ORMLiteHelper helper;

    public ContaDao(ORMLiteHelper helper) {
        this.helper = helper;
    }

    public Dao<Conta, Integer> getCadastroDao() throws SQLException {
        if(contaDao == null){
           contaDao = helper.getDao(Conta.class);
        }
        return contaDao;
    }
}

