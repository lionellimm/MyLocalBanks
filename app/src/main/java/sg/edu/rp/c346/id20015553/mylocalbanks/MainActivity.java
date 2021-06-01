package sg.edu.rp.c346.id20015553.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView DBS;
    ImageView OCBC;
    ImageView UOB;

//    boolean dbsFav = false;
//    boolean ocbcFav = false;
//    boolean uobFav = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.btnDBS);
        OCBC = findViewById(R.id.btnOCBC);
        UOB = findViewById(R.id.btnUOB);


        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    String clickedOn = "";
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(v== DBS){
            clickedOn = "dbs";
        }
        else if(v == OCBC){
            clickedOn = "ocbc";
        }
        else if(v == UOB){
            clickedOn = "uob";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(clickedOn.equalsIgnoreCase("dbs")) {
            if (item.getTitle().equals("Website")) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.dbs.com"));
                startActivity(intent);

            }
            else if (item.getTitle().equals("Contact the bank")) {
                String num = "18001111111";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(intentCall);
            }
//            else if(item.getTitle().equals("Toggle Favourite")){
//                if(dbsFav == true){
//                    dbsFav = false;
//                }
//                else if(dbsFav == false){
//                    dbsFav = true;
//                }
//            }
        }
        else if(clickedOn.equalsIgnoreCase("ocbc")) {
            if (item.getTitle().equals("Website")) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(intent);
            }
            else if (item.getTitle().equals("Contact the bank")) {
                String num = "18003633333";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(intentCall);
            }
//            else if(item.getTitle().equals("Toggle Favourite")){
//                if(ocbcFav == true){
//                    ocbcFav = false;
//                }
//                else if(ocbcFav == false){
//                    ocbcFav = true;
//                }
//            }
        }
        else if(clickedOn.equalsIgnoreCase("uob")) {
            if (item.getTitle().equals("Website")) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.uob.com"));
                startActivity(intent);
            }
            else if (item.getTitle().equals("Contact the bank")) {
                String num = "18002222121";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(intentCall);
            }
//            else if(item.getTitle().equals("Toggle Favourite")){
//                if(uobFav == true){
//                    uobFav = false;
//                }
//                else if(uobFav == false){
//                    uobFav = true;
//                }
//            }
        }

        return super.onContextItemSelected(item);
    }
    int count = 0;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.

        if (item.getTitle().equals("Chinese")) {
//            DBS.setText("星展银行");
//            OCBC.setText("华侨银行");
//            UOB.setText("大华银行");
            DBS.setImageResource(R.drawable.dbs_chinese);
            UOB.setImageResource(R.drawable.uob_chinese);
            return true;
        } else if (item.getTitle().equals("English")) {
//            DBS.setText("DBS");
//            OCBC.setText("OCBC");
//            UOB.setText("UOB");
            DBS.setImageResource(R.drawable.dbs);
            UOB.setImageResource(R.drawable.uob);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}