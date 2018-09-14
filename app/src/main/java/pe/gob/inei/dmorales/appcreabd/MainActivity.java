package pe.gob.inei.dmorales.appcreabd;

import android.content.ContentValues;
import android.content.Context;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    public String TAG = "ExelLog";
    public Button btnCrearBD;
    public Button btnExportarBD;
    public Button btnResumenCajas;
    public Button btnResumenAsistencia;
    public Button btnResumenInventario;
    public Button btnColeccionCajas;
    public Button btnColeccionInventario;
    public Button btnColeccionAsistencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrearBD = (Button)findViewById(R.id.cargaDatos);
        btnExportarBD = (Button)findViewById(R.id.exportaBD);


        btnCrearBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leerExcelCajas(MainActivity.this);
            }
        });

        btnExportarBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    exportarBD();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public ArrayList<Caja> leerExcelCajas(Context context) {
        ArrayList<Caja> cajas = new ArrayList<>();
        Data data =  new Data(MainActivity.this);
        data.open();
        try{
            InputStream stream = context.getAssets().open("cajas.xls");
            POIFSFileSystem myFileSystem = new POIFSFileSystem(stream);
            HSSFWorkbook miLibro = new HSSFWorkbook(myFileSystem);
            HSSFSheet miHoja = miLibro.getSheetAt(0);
            Iterator IteradorFila = miHoja.rowIterator();
            while(IteradorFila.hasNext()){
                HSSFRow miFila = (HSSFRow) IteradorFila.next();
                Iterator iteradorCelda = miFila.cellIterator();
                Caja caja = new Caja();
                ContentValues contentValues = new ContentValues();
                int contCelda = 1;
                while(iteradorCelda.hasNext()){
                    HSSFCell miCelda = (HSSFCell) iteradorCelda.next();
                    String valorCelda = miCelda.getStringCellValue();
                    switch (contCelda){
                        case HojaCajas.CAJA_CODIGO:if (valorCelda.equals("NULL"))caja.setCod_barra_caja(null); else caja.setCod_barra_caja(valorCelda);break;
                        case HojaCajas.CAJA_CCDD:if (valorCelda.equals("NULL"))caja.setCcdd(null); else caja.setCcdd(valorCelda);break;
                        case HojaCajas.CAJA_DEPARTAMENTO:if (valorCelda.equals("NULL"))caja.setDepartamento(null); else caja.setDepartamento(valorCelda);break;
                        case HojaCajas.CAJA_IDNACIONAL:if (valorCelda.equals("NULL"))caja.setIdnacional(-1); else caja.setIdnacional(Integer.parseInt(valorCelda));break;
                        case HojaCajas.CAJA_IDSEDE:if (valorCelda.equals("NULL"))caja.setIdsede(null); else caja.setIdsede(valorCelda);break;
                        case HojaCajas.CAJA_NOMSEDE:if (valorCelda.equals("NULL"))caja.setNomsede(null); else caja.setNomsede(valorCelda);break;
                        case HojaCajas.CAJA_IDLOCAL:if (valorCelda.equals("NULL"))caja.setIdlocal(-1); else caja.setIdlocal(Integer.parseInt(valorCelda));break;
                        case HojaCajas.CAJA_NOMLOCAL:if (valorCelda.equals("NULL"))caja.setLocal(null); else caja.setLocal(valorCelda);break;
                        case HojaCajas.CAJA_TIPO:if (valorCelda.equals("NULL"))caja.setTipo(-1); else caja.setTipo(Integer.parseInt(valorCelda));break;
                        case HojaCajas.CAJA_NLADO:if (valorCelda.equals("NULL"))caja.setNlado(-1); else caja.setNlado(Integer.parseInt(valorCelda));break;
                        case HojaCajas.CAJA_ACL:if (valorCelda.equals("NULL"))caja.setAcl(-1); else caja.setAcl(Integer.parseInt(valorCelda));break;
                    }
                    contCelda++;
                }
                data.insertarCaja(caja);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if (data.getNumeroItemsCajas() > 0) Toast.makeText(context, "Listo creado", Toast.LENGTH_SHORT).show();
        data.close();
        return cajas;
    }

    public void exportarBD()throws IOException {
        String inFileName = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        InputStream myInput = new FileInputStream(inFileName);
        String outFileName = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/miBD.sqlite";
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) != -1){
            if (length > 0){
                myOutput.write(buffer,0,length);
            }
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();
        Toast.makeText(this, "Copiado", Toast.LENGTH_SHORT).show();
    }


    public File getPublicDBStorageDir(String fileName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
        if (!file.mkdirs()) {
            Log.e("CREAR BD", "Dirtectorio no creado");
        }
        return file;
    }
}
