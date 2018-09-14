package pe.gob.inei.dmorales.appcreabd;

import android.content.ContentValues;

public class Asistencia {
    private String _id;
    private String dni;
    private int idnacional;
    private String ccdd;
    private String departamento;
    private String idsede;
    private String sede;
    private int idlocal;
    private String local;
    private String direccion;
    private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private int naula;
    private String discapacidad;
    private String prioridad;
    private String cod_pagina;

    public Asistencia(String _id, String dni, int idnacional, String ccdd, String departamento, String idsede, String sede, int idlocal, String local, String direccion, String nombres, String ape_paterno, String ape_materno, int naula, String discapacidad, String prioridad, String cod_pagina) {
        this._id = _id;
        this.dni = dni;
        this.idnacional = idnacional;
        this.ccdd = ccdd;
        this.departamento = departamento;
        this.idsede = idsede;
        this.sede = sede;
        this.idlocal = idlocal;
        this.local = local;
        this.direccion = direccion;
        this.nombres = nombres;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.naula = naula;
        this.discapacidad = discapacidad;
        this.prioridad = prioridad;
        this.cod_pagina = cod_pagina;
    }

    public Asistencia() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdnacional() {
        return idnacional;
    }

    public void setIdnacional(int idnacional) {
        this.idnacional = idnacional;
    }

    public String getCcdd() {
        return ccdd;
    }

    public void setCcdd(String ccdd) {
        this.ccdd = ccdd;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getIdsede() {
        return idsede;
    }

    public void setIdsede(String idsede) {
        this.idsede = idsede;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public int getNaula() {
        return naula;
    }

    public void setNaula(int naula) {
        this.naula = naula;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getCod_pagina() {
        return cod_pagina;
    }

    public void setCod_pagina(String cod_pagina) {
        this.cod_pagina = cod_pagina;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        if (dni != null) contentValues.put(SQLConstantes.asistencia_dni,dni);
        if (idnacional != -1) contentValues.put(SQLConstantes.asistencia_idnacional,idnacional);
        if (ccdd != null) contentValues.put(SQLConstantes.asistencia_ccdd,ccdd);
        if (departamento != null) contentValues.put(SQLConstantes.asistencia_departamento,departamento);
        if (idsede != null) contentValues.put(SQLConstantes.asistencia_idsede,idsede);
        if (sede != null) contentValues.put(SQLConstantes.asistencia_sede,sede);
        if (idlocal != -1) contentValues.put(SQLConstantes.asistencia_idlocal,idlocal);
        if (local != null) contentValues.put(SQLConstantes.asistencia_local,local);
        if (direccion != null)  contentValues.put(SQLConstantes.asistencia_direccion,direccion);
        if (nombres != null)  contentValues.put(SQLConstantes.asistencia_nombres,nombres);
        if (ape_paterno != null) contentValues.put(SQLConstantes.asistencia_ape_paterno,ape_paterno);
        if (ape_materno != null) contentValues.put(SQLConstantes.asistencia_ape_materno,ape_materno);
        if (naula != -1) contentValues.put(SQLConstantes.asistencia_naula,naula);
        if (discapacidad != null) contentValues.put(SQLConstantes.asistencia_discapacidad,discapacidad);
        if (prioridad != null) contentValues.put(SQLConstantes.asistencia_prioridad,prioridad);
        if (cod_pagina != null) contentValues.put(SQLConstantes.asistencia_cod_pagina,cod_pagina);
        return contentValues;
    }
}
