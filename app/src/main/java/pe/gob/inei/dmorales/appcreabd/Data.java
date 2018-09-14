package pe.gob.inei.dmorales.appcreabd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Data {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context){
        this.sqLiteOpenHelper = new DBHelper(context);
        this.sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        this.context = context;
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public long getNumeroItemsCajas(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tablacajas);
    }

    public long getNumeroItemsAsistencias(){
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,SQLConstantes.tablaasistencia);
    }

    public void insertarCaja(Caja caja){
        ContentValues contentValues = caja.toValues();
        sqLiteDatabase.insert(SQLConstantes.tablacajas,null,contentValues);
    }
    public void insertarCajas(ArrayList<Caja> cajas){
        long items = getNumeroItemsCajas();
        if(items == 0){
            for (Caja caja : cajas) {
                try {
                    insertarCaja(caja);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public Caja getCaja(String codBarra){
        Caja caja = null;
        String[] whereArgs = new String[]{codBarra};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas,
                    null,SQLConstantes.WHERE_CLAUSE_CODIGO_CAJA,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                caja = new Caja();
                caja.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_id)));
                caja.setCod_barra_caja(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_codcaja)));
                caja.setIdnacional(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_idnacional)));
                caja.setCcdd(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_ccdd)));
                caja.setDepartamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_departamento)));
                caja.setIdsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_idsede)));
                caja.setNomsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_nomsede)));
                caja.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_idlocal)));
                caja.setLocal(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_nomlocal)));
                caja.setTipo(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_tipo)));
                caja.setNlado(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_nlado)));
                caja.setAcl(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_acl)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return caja;
    }

    public ArrayList<Caja> getAllCajas(){
        ArrayList<Caja> caratulas = new ArrayList<Caja>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas,
                    null,null,null,null,null,null);
            while(cursor.moveToNext()) {
                Caja caja = new Caja();
                caja.set_id(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_id)));
                caja.setCod_barra_caja(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_codcaja)));
                caja.setIdnacional(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_idnacional)));
                caja.setCcdd(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_ccdd)));
                caja.setDepartamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_departamento)));
                caja.setIdsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_idsede)));
                caja.setNomsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_nomsede)));
                caja.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_idlocal)));
                caja.setLocal(cursor.getString(cursor.getColumnIndex(SQLConstantes.cajas_nomlocal)));
                caja.setTipo(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_tipo)));
                caja.setNlado(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_nlado)));
                caja.setAcl(cursor.getInt(cursor.getColumnIndex(SQLConstantes.cajas_acl)));
                caratulas.add(caja);
            }
        }finally {
            if(cursor!=null) cursor.close();
        }
        return caratulas;
    }




    public void insertarAsistencia(Asistencia asistencia){
        ContentValues contentValues = asistencia.toValues();
        sqLiteDatabase.insert(SQLConstantes.tablaasistencia,null,contentValues);
    }
    public void insertarAsistencias(ArrayList<Asistencia> asistencias){
        long items = getNumeroItemsAsistencias();
        if(items == 0){
            for (Asistencia asistencia : asistencias) {
                try {
                    insertarAsistencia(asistencia);
                }catch (SQLiteException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public Asistencia getAsistencia(String dni){
        Asistencia asistencia = null;
        String[] whereArgs = new String[]{dni};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaasistencia,
                    null,SQLConstantes.WHERE_CLAUSE_DNI,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                asistencia = new Asistencia();
                asistencia.setDni(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_dni)));
                asistencia.setIdnacional(cursor.getInt(cursor.getColumnIndex(SQLConstantes.asistencia_idnacional)));
                asistencia.setCcdd(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_ccdd)));
                asistencia.setDepartamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_departamento)));
                asistencia.setIdsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_idsede)));
                asistencia.setSede(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_sede)));
                asistencia.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.asistencia_idlocal)));
                asistencia.setLocal(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_local)));
                asistencia.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_direccion)));
                asistencia.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_nombres)));
                asistencia.setApe_materno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_ape_materno)));
                asistencia.setApe_paterno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_ape_paterno)));
                asistencia.setNaula(cursor.getInt(cursor.getColumnIndex(SQLConstantes.asistencia_naula)));
                asistencia.setDiscapacidad(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_discapacidad)));
                asistencia.setPrioridad(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_prioridad)));
                asistencia.setCod_pagina(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_cod_pagina)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return asistencia;
    }

    public ArrayList<Asistencia> getAllAsistencias(){
        ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaasistencia,
                    null,null,null,null,null,null);
            while(cursor.moveToNext()) {
                Asistencia asistencia = new Asistencia();
                asistencia = new Asistencia();
                asistencia.setDni(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_dni)));
                asistencia.setIdnacional(cursor.getInt(cursor.getColumnIndex(SQLConstantes.asistencia_idnacional)));
                asistencia.setCcdd(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_ccdd)));
                asistencia.setDepartamento(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_departamento)));
                asistencia.setIdsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_idsede)));
                asistencia.setSede(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_sede)));
                asistencia.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.asistencia_idlocal)));
                asistencia.setLocal(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_local)));
                asistencia.setDireccion(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_direccion)));
                asistencia.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_nombres)));
                asistencia.setApe_paterno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_ape_paterno)));
                asistencia.setApe_paterno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_naula)));
                asistencia.setApe_paterno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_discapacidad)));
                asistencia.setApe_paterno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_prioridad)));
                asistencia.setApe_paterno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_cod_pagina)));
                asistencias.add(asistencia);
            }
        }finally {
            if(cursor!=null) cursor.close();
        }
        return asistencias;
    }
}
