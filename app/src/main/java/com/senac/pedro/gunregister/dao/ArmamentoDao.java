package com.senac.pedro.gunregister.dao;

import android.content.Context;

import com.senac.pedro.gunregister.model.Armamento;

public class ArmamentoDao extends DaoHelper<Armamento> {
    public ArmamentoDao(Context c) {
        super(c, Armamento.class);
    }
    }

