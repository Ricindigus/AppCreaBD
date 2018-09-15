package pe.gob.inei.dmorales.appcreabd;

import android.content.ContentValues;

public class Inventario {
    private String id;
    private String codigo;
    private int tipo;
    private int idnacional;
    private String ccdd;
    private String departamento;
    private String idsede;
    private String sede ;
    private int idlocal;
    private String local;
    private String direccion;
    private String dni;
    private String ape_paterno;
    private String ape_materno;
    private String nombres;
    private int naula;
    private String codpagina;

    public Inventario(String id, String codigo, int tipo, int idnacional, String ccdd, String departamento, String idsede, String sede, int idlocal, String local, String direccion, String dni, String ape_paterno, String ape_materno, String nombres, int naula, String codpagina) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.idnacional = idnacional;
        this.ccdd = ccdd;
        this.departamento = departamento;
        this.idsede = idsede;
        this.sede = sede;
        this.idlocal = idlocal;
        this.local = local;
        this.direccion = direccion;
        this.dni = dni;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.nombres = nombres;
        this.naula = naula;
        this.codpagina = codpagina;
    }

    public Inventario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getIdnacional() {
        return idnacional;
    }

    public void setIdnacional(int idnacional) {
        this.idnacional = idnacional;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public int getNaula() {
        return naula;
    }

    public void setNaula(int naula) {
        this.naula = naula;
    }

    public String getCodpagina() {
        return codpagina;
    }

    public void setCodpagina(String codpagina) {
        this.codpagina = codpagina;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        if (codigo != null) contentValues.put(SQLConstantes.inventario_codigo,codigo);
        if (tipo != -1) contentValues.put(SQLConstantes.inventario_tipo,tipo);
        if (idnacional != -1) contentValues.put(SQLConstantes.inventario_idnacional,idnacional);
        if (ccdd != null) contentValues.put(SQLConstantes.inventario_ccdd,ccdd);
        if (departamento != null) contentValues.put(SQLConstantes.inventario_departamento,departamento);
        if (idsede != null) contentValues.put(SQLConstantes.inventario_idsede,idsede);
        if (sede != null) contentValues.put(SQLConstantes.inventario_sede,sede);
        if (idlocal != -1) contentValues.put(SQLConstantes.inventario_idlocal,idlocal);
        if (local != null) contentValues.put(SQLConstantes.inventario_local,local);
        if (direccion != null)  contentValues.put(SQLConstantes.inventario_direccion,direccion);
        if (dni != null)  contentValues.put(SQLConstantes.inventario_dni,dni);
        if (ape_paterno !=null) contentValues.put(SQLConstantes.inventario_ape_paterno,ape_paterno);
        if (ape_materno != null) contentValues.put(SQLConstantes.inventario_ape_materno,ape_materno);
        if (nombres != null) contentValues.put(SQLConstantes.inventario_nombres,nombres);
        if (naula != -1) contentValues.put(SQLConstantes.inventario_naula,naula);
        if (codpagina != null) contentValues.put(SQLConstantes.inventario_codpagina,codpagina);
        return contentValues;
    }

}
