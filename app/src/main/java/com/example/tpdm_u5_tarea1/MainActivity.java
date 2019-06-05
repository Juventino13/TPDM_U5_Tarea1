package com.example.tpdm_u5_tarea1;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS=0;
    final int SEND_SMS_PERMISSION_REQUEST_CODE=1;


    static BaseDatos basecansiones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basecansiones=new BaseDatos(this,"BASE_CANCIONES",null,1);


        if(!checkPermission(Manifest.permission.SEND_SMS)){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_REQUEST_CODE);
            Toast.makeText(this,"PREPARADO",Toast.LENGTH_LONG).show();
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED){
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.RECEIVE_SMS)){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},MY_PERMISSIONS_REQUEST_RECEIVE_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults){
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST_RECEIVE_SMS:
            {
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"RECIBIENDO",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"DENEGADO",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public boolean checkPermission(String permission){
        int check=ContextCompat.checkSelfPermission(this,permission);
        return (check==PackageManager.PERMISSION_GRANTED);
    }

    public static String consultarregaeton(int ID,Context context) {
        String cancion="no disponible";
        try {
            SQLiteDatabase selec=basecansiones.getReadableDatabase();
            Cursor c=selec.rawQuery("SELECT * FROM CANCIONESREG WHERE IDCANCIONREG="+ID,null);

            if(c.moveToFirst()){
                do{
                    cancion=c.getString(1);
                }while (c.moveToNext());
                selec.close();
            }else{
                Toast.makeText(context,"ERROR, Aún no hay datos para mostrar",Toast.LENGTH_LONG).show();
            }
        }catch (SQLiteException e){
            Toast.makeText(context,"Error de consulta",Toast.LENGTH_LONG).show();
        }
        return cancion;
    }

    public static void sendsongreggaeton(String phoneNo,String[] partes,Context context){
        if (partes[0].equals("DADDY") && partes[1].equals("2222")) {
            int id = (int) (Math.random() * 5) + 1;

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null,consultarregaeton(id, context), null, null);

            Toast.makeText(context, "MENSAJE ENVIADO!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "MENSAJE MAL ESTRUCTURADO", Toast.LENGTH_LONG).show();
        }
    }






    public static String consultarRock(int ID,Context context) {
        String cancionrock="no disponible";
        try {
            SQLiteDatabase selec=basecansiones.getReadableDatabase();
            Cursor c=selec.rawQuery("SELECT * FROM CANCIONESROCK WHERE IDCANCIONROCK="+ID,null);

            if(c.moveToFirst()){
                do{
                    cancionrock=c.getString(1);
                }while (c.moveToNext());
                selec.close();
            }else{
                Toast.makeText(context,"ERROR, Aún no hay datos para mostrar",Toast.LENGTH_LONG).show();
            }
        }catch (SQLiteException e){
            Toast.makeText(context,"Error de consulta",Toast.LENGTH_LONG).show();
        }
        return cancionrock;
    }

    public static void sendSongRock(String phoneNo,String[] partes,Context context){
        if (partes[0].equals("ROCK") && partes[1].equals("6666")) {
            int id = (int) (Math.random() * 5) + 1;

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null,consultarRock(id, context), null, null);

            Toast.makeText(context, "MENSAJE ENVIADO!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "MENSAJE MAL ESTRUCTURADO", Toast.LENGTH_LONG).show();
        }
    }
}
