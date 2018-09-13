package pe.gob.inei.dmorales.appcreabd;

import android.content.Context;
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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    public String TAG = "ExelLog";
    public Button btnCargaBD;
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
        btnCargaBD = (Button)findViewById(R.id.cargaDatos);

        btnCargaBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leerExcelCajas(MainActivity.this);
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
                int contCelda = 1;
                while(iteradorCelda.hasNext()){
                    HSSFCell miCelda = (HSSFCell) iteradorCelda.next();
                    String valorCelda = miCelda.getStringCellValue();
                    switch (contCelda){
                        case HojaCajas.CAJA_CODIGO:if (valorCelda.equals("NULL"))caja.setCod_barra_caja(null); else caja.setCod_barra_caja(valorCelda);break;
                        case HojaCajas.CAJA_CCDD:if (valorCelda.equals("NULL"))caja.setCcdd(null); else caja.setCcdd(valorCelda);break;
                        case HojaCajas.CAJA_DEPARTAMENTO:if (valorCelda.equals("NULL"))caja.setDepartamento(null); else caja.setDepartamento(valorCelda);break;
                        case HojaCajas.CAJA_IDNACIONAL:if (valorCelda.equals("NULL"))caja.setIdnacional(0); else caja.setIdnacional(Integer.parseInt(valorCelda));break;
                        case HojaCajas.CAJA_IDSEDE:if (valorCelda.equals("NULL"))caja.setIdsede(null); else caja.setIdsede(valorCelda);break;
                        case HojaCajas.CAJA_NOMSEDE:if (valorCelda.equals("NULL"))caja.setNomsede(null); else caja.setNomsede(valorCelda);break;
                        case HojaCajas.CAJA_IDLOCAL:if (valorCelda.equals("NULL"))caja.setIdlocal(0); else caja.setIdlocal(Integer.parseInt(valorCelda));break;
                        case HojaCajas.CAJA_NOMLOCAL:if (valorCelda.equals("NULL"))caja.setLocal(null); else caja.setLocal(valorCelda);break;
                        case HojaCajas.CAJA_TIPO:if (valorCelda.equals("NULL"))caja.setTipo(0); else caja.setTipo(Integer.parseInt(valorCelda));break;
                        case HojaCajas.CAJA_NLADO:if (valorCelda.equals("NULL"))caja.setNlado(0); else caja.setNlado(Integer.parseInt(valorCelda));break;
                        case HojaCajas.CAJA_ACL:if (valorCelda.equals("NULL"))caja.setAcl(0); else caja.setAcl(Integer.parseInt(valorCelda));break;
                    }
                    contCelda++;
                }
                Toast.makeText(context, ""+caja.toString(), Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        data.close();
        return cajas;
    }
}
