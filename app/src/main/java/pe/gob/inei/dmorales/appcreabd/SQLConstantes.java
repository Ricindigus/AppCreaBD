package pe.gob.inei.dmorales.appcreabd;

public class SQLConstantes {
    public static final String tablacajas = "cajas";

    public static final String cajas_id = "_id";
    public static final String cajas_codcaja = "codcaja";
    public static final String cajas_idnacional = "idnacional";
    public static final String cajas_ccdd = "ccdd";
    public static final String cajas_codsede = "codsede";
    public static final String cajas_nomsede = "nomsede";
    public static final String cajas_codlocal = "codlocal";
    public static final String cajas_nomlocal = "nomlocal";
    public static final String cajas_tipo = "tipo";
    public static final String cajas_nlado = "nlado";
    public static final String cajas_acl = "acl";

    public static final String CREAR_TABALA_CAJAS =
            "CREATE TABLE " + tablacajas + "(" +
                    cajas_id + " INTEGER PRIMARY KEY," +
                    cajas_codcaja + " TEXT," +
                    cajas_idnacional + " INTEGER," +
                    cajas_ccdd + " TEXT," +
                    cajas_codsede + " TEXT," +
                    cajas_nomsede + " TEXT," +
                    cajas_codlocal + " INTEGER," +
                    cajas_nomlocal + " TEXT," +
                    cajas_tipo + " INTEGER," +
                    cajas_nlado + " INTEGER," +
                    cajas_acl + " INTEGER" + ");"
    ;
}
