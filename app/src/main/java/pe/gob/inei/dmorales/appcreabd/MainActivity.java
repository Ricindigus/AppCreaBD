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

    public void leerExcelCajas(Context context) {
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
                    switch (contCelda){
                        case HojaCajas.CAJA_CODIGO:caja.setCodcaja(miCelda.getStringCellValue());break;
                        case HojaCajas.CAJA_CDD:caja.setCcdd(miCelda.getStringCellValue());break;
                        case HojaCajas.CAJA_IDNACIONAL:caja.setIdnacional(Integer.parseInt(miCelda.getStringCellValue()));break;
                        case HojaCajas.CAJA_IDSEDE:caja.setCodsede(miCelda.getStringCellValue());break;
                        case HojaCajas.CAJA_NOMSEDE:caja.setNomsede(miCelda.getStringCellValue());break;
                        case HojaCajas.CAJA_IDLOCAL:caja.setCodlocal(Integer.parseInt(miCelda.getStringCellValue()));break;
                        case HojaCajas.CAJA_NOMLOCAL:caja.setNomlocal(miCelda.getStringCellValue());break;
                        case HojaCajas.CAJA_TIPO:caja.setTipo(Integer.parseInt(miCelda.getStringCellValue()));break;
                        case HojaCajas.CAJA_NLADO:caja.setNlado(Integer.parseInt(miCelda.getStringCellValue()));break;
                        case HojaCajas.CAJA_ACL:caja.setAcl(Integer.parseInt(miCelda.getStringCellValue()));break;
                    }
//                    if(contador == 1) itemMarco.setNumero(""+(int)myCell.getNumericCellValue());
//                    if(contador == 2) itemMarco.setRuc(myCell.toString());
//                    if(contador == 3) itemMarco.setRazonSocial(""+(int)myCell.getNumericCellValue());
                    contCelda++;
                }
                Toast.makeText(context, ""+caja.toString(), Toast.LENGTH_SHORT).show();

            }
        }catch (Exception e){e.printStackTrace(); }
    }
}
