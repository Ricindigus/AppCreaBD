package pe.gob.inei.dmorales.appcreabd;

import android.content.ContentValues;

public class Caja {
    private String _id;
    private String cod_barra_caja;
    private int idnacional;
    private String ccdd;
    private String departamento;
    private String idsede;
    private String nomsede;
    private int idlocal;
    private String local;
    private int tipo;
    private int nlado;
    private int acl;


    public Caja(String _id, String cod_barra_caja, int idnacional, String ccdd, String departamento, String idsede, String nomsede, int idlocal, String local, int tipo, int nlado, int acl) {
        this._id = _id;
        this.cod_barra_caja = cod_barra_caja;
        this.idnacional = idnacional;
        this.ccdd = ccdd;
        this.departamento = departamento;
        this.idsede = idsede;
        this.nomsede = nomsede;
        this.idlocal = idlocal;
        this.local = local;
        this.tipo = tipo;
        this.nlado = nlado;
        this.acl = acl;
    }

    public Caja() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCod_barra_caja() {
        return cod_barra_caja;
    }

    public void setCod_barra_caja(String cod_barra_caja) {
        this.cod_barra_caja = cod_barra_caja;
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

    public String getNomsede() {
        return nomsede;
    }

    public void setNomsede(String nomsede) {
        this.nomsede = nomsede;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNlado() {
        return nlado;
    }

    public void setNlado(int nlado) {
        this.nlado = nlado;
    }

    public int getAcl() {
        return acl;
    }

    public void setAcl(int acl) {
        this.acl = acl;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLConstantes.cajas_id,_id);
        contentValues.put(SQLConstantes.cajas_codcaja,cod_barra_caja);
        contentValues.put(SQLConstantes.cajas_idnacional,idnacional);
        contentValues.put(SQLConstantes.cajas_ccdd,ccdd);
        contentValues.put(SQLConstantes.cajas_departamento,departamento);
        contentValues.put(SQLConstantes.cajas_idsede,idsede);
        contentValues.put(SQLConstantes.cajas_nomsede,nomsede);
        contentValues.put(SQLConstantes.cajas_idlocal,idlocal);
        contentValues.put(SQLConstantes.cajas_nomlocal,local);
        contentValues.put(SQLConstantes.cajas_tipo,tipo);
        contentValues.put(SQLConstantes.cajas_nlado,nlado);
        contentValues.put(SQLConstantes.cajas_acl,acl);
        return contentValues;
    }
}
