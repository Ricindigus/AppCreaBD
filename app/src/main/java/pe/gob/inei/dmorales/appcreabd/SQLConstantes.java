package pe.gob.inei.dmorales.appcreabd;

public class SQLConstantes {
    public static String DB_PATH = "/data/data/pe.gob.inei.dmorales.appcreabd/databases/";
    public static String DB_NAME = "mydatabase.";
    public static final String tablacajas = "cajas";

    public static final String cajas_id = "_id";
    public static final String cajas_codcaja = "cod_barra_caja";
    public static final String cajas_idnacional = "idnacional";
    public static final String cajas_ccdd = "ccdd";
    public static final String cajas_departamento = "departamento";
    public static final String cajas_idsede = "idsede";
    public static final String cajas_nomsede = "nomsede";
    public static final String cajas_idlocal = "idlocal";
    public static final String cajas_nomlocal = "local";
    public static final String cajas_tipo = "tipo";
    public static final String cajas_nlado = "nlado";
    public static final String cajas_acl = "acl";

    public static final String CREAR_TABLA_CAJAS =
            "CREATE TABLE " + tablacajas + "(" +
                    cajas_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    cajas_codcaja + " TEXT," +
                    cajas_idnacional + " INTEGER," +
                    cajas_ccdd + " TEXT," +
                    cajas_departamento + " TEXT," +
                    cajas_idsede + " TEXT," +
                    cajas_nomsede + " TEXT," +
                    cajas_idlocal + " INTEGER," +
                    cajas_nomlocal + " TEXT," +
                    cajas_tipo + " INTEGER," +
                    cajas_nlado + " INTEGER," +
                    cajas_acl + " INTEGER" + ");"
    ;

    public static final String WHERE_CLAUSE_CODIGO_CAJA = "cod_barra_caja=?";

    public static final String DELETE_TABLA_CAJAS = "DROP TABLE " + tablacajas;

}
