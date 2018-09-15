package pe.gob.inei.dmorales.appcreabd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, SQLConstantes.DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLConstantes.CREAR_TABLA_CAJAS);
        db.execSQL(SQLConstantes.CREAR_TABLA_ASISTENCIA);
        db.execSQL(SQLConstantes.CREAR_TABLA_INVENTARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLConstantes.DELETE_TABLA_CAJAS);
        db.execSQL(SQLConstantes.DELETE_TABLA_ASISTENCIA);
        db.execSQL(SQLConstantes.DELETE_TABLA_INVENTARIO);
        onCreate(db);
    }
}
