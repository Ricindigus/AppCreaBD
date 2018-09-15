package pe.gob.inei.dmorales.appcreabd;

public class SQLConstantes {
    public static String DB_PATH = "/data/data/pe.gob.inei.dmorales.appcreabd/databases/";
    public static String DB_NAME = "mydatabase.";
    public static final String tablacajas = "cajas";
    public static final String tablaasistencia = "asistencia";
    public static final String tablainventario = "inventario";


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



    public static String asistencia_id = "_id";
    public static String asistencia_dni = "dni";
    public static String asistencia_idnacional = "idnacional";
    public static String asistencia_ccdd = "ccdd";
    public static String asistencia_departamento = "departamento";
    public static String asistencia_idsede = "idsede";
    public static String asistencia_sede = "sede";
    public static String asistencia_idlocal = "idlocal";
    public static String asistencia_local = "local";
    public static String asistencia_direccion = "direccion";
    public static String asistencia_nombres = "nombres";
    public static String asistencia_ape_paterno = "ape_paterno";
    public static String asistencia_ape_materno = "ape_materno";
    public static String asistencia_naula = "naula";
    public static String asistencia_discapacidad = "discapacidad";
    public static String asistencia_prioridad = "prioridad";
    public static String asistencia_cod_pagina = "cod_pagina";


    public static final String CREAR_TABLA_ASISTENCIA =
            "CREATE TABLE " + tablaasistencia + "(" +
                    asistencia_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    asistencia_dni + " TEXT," +
                    asistencia_idnacional + " INTEGER," +
                    asistencia_ccdd + " TEXT," +
                    asistencia_departamento + " TEXT," +
                    asistencia_idsede + " TEXT," +
                    asistencia_sede + " TEXT," +
                    asistencia_idlocal + " INTEGER," +
                    asistencia_local + " TEXT," +
                    asistencia_direccion + " TEXT," +
                    asistencia_nombres + " TEXT," +
                    asistencia_ape_paterno + " TEXT," +
                    asistencia_ape_materno + " TEXT," +
                    asistencia_naula + " INTEGER," +
                    asistencia_discapacidad + " TEXT," +
                    asistencia_prioridad + " TEXT," +
                    asistencia_cod_pagina + " TEXT" + ");"
            ;


    public static final String WHERE_CLAUSE_DNI = "dni=?";
    public static final String DELETE_TABLA_ASISTENCIA = "DROP TABLE " + tablaasistencia;

    public static String inventario_id = "_id";
    public static String inventario_codigo= "codigo";
    public static String inventario_tipo = "tipo";
    public static String inventario_idnacional = "idnacional";
    public static String inventario_ccdd = "ccdd";
    public static String inventario_departamento = "departamento";
    public static String inventario_idsede = "idsede";
    public static String inventario_sede = "sede";
    public static String inventario_idlocal = "idlocal";
    public static String inventario_local = "local";
    public static String inventario_direccion = "direccion";
    public static String inventario_dni = "dni";
    public static String inventario_ape_paterno = "ape_paterno";
    public static String inventario_ape_materno = "ape_materno";
    public static String inventario_nombres = "nombres";
    public static String inventario_naula = "naula";
    public static String inventario_codpagina = "codpagina";


    public static final String CREAR_TABLA_INVENTARIO =
            "CREATE TABLE " + tablainventario + "(" +
                    inventario_id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    inventario_codigo + " TEXT," +
                    inventario_tipo + " INTEGER," +
                    inventario_idnacional + " INTEGER," +
                    inventario_ccdd + " TEXT," +
                    inventario_departamento + " TEXT," +
                    inventario_idsede + " TEXT," +
                    inventario_sede + " TEXT," +
                    inventario_idlocal + " INTEGER," +
                    inventario_local + " TEXT," +
                    inventario_direccion + " TEXT," +
                    inventario_dni + " TEXT," +
                    inventario_nombres + " TEXT," +
                    inventario_ape_paterno + " TEXT," +
                    inventario_ape_materno + " TEXT," +
                    inventario_naula + " INTEGER," +
                    inventario_codpagina + " TEXT" + ");"
            ;


    public static final String WHERE_CLAUSE_CODIGO= "codigo=?";
    public static final String DELETE_TABLA_INVENTARIO = "DROP TABLE " + tablainventario;

}
