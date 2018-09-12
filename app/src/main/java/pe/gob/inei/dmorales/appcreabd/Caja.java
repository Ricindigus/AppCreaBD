package pe.gob.inei.dmorales.appcreabd;

import android.content.ContentValues;

public class Caja {
    private String _id;
    private String codcaja;
    private String ccdd;
    private int idnacional;
    private String codsede;
    private String nomsede;
    private int codlocal;
    private String nomlocal;
    private int tipo;
    private int nlado;
    private int acl;

    public Caja(String _id, String codcaja, String ccdd, int idnacional, String codsede, String nomsede, int codlocal, String nomlocal, int tipo, int nlado, int acl) {
        this._id = _id;
        this.codcaja = codcaja;
        this.ccdd = ccdd;
        this.idnacional = idnacional;
        this.codsede = codsede;
        this.nomsede = nomsede;
        this.codlocal = codlocal;
        this.nomlocal = nomlocal;
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

    public String getCodcaja() {
        return codcaja;
    }

    public void setCodcaja(String codcaja) {
        this.codcaja = codcaja;
    }

    public String getCcdd() {
        return ccdd;
    }

    public void setCcdd(String ccdd) {
        this.ccdd = ccdd;
    }

    public int getIdnacional() {
        return idnacional;
    }

    public void setIdnacional(int idnacional) {
        this.idnacional = idnacional;
    }

    public String getCodsede() {
        return codsede;
    }

    public void setCodsede(String codsede) {
        this.codsede = codsede;
    }

    public String getNomsede() {
        return nomsede;
    }

    public void setNomsede(String nomsede) {
        this.nomsede = nomsede;
    }

    public int getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(int codlocal) {
        this.codlocal = codlocal;
    }

    public String getNomlocal() {
        return nomlocal;
    }

    public void setNomlocal(String nomlocal) {
        this.nomlocal = nomlocal;
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
        contentValues.put(SQLConstantes.cajas_codcaja,codcaja);
        contentValues.put(SQLConstantes.cajas_idnacional,idnacional);
        contentValues.put(SQLConstantes.cajas_ccdd,ccdd);
        contentValues.put(SQLConstantes.cajas_codsede,codsede);
        contentValues.put(SQLConstantes.cajas_nomsede,nomsede);
        contentValues.put(SQLConstantes.cajas_codlocal,codlocal);
        contentValues.put(SQLConstantes.cajas_nomlocal,nomlocal);
        contentValues.put(SQLConstantes.cajas_tipo,tipo);
        contentValues.put(SQLConstantes.cajas_nlado,nlado);
        contentValues.put(SQLConstantes.cajas_acl,acl);
        return contentValues;
    }
}
