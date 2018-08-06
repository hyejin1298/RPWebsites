package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


TextView tvCat;
TextView tvSub;
Spinner spnCat;
Spinner spnSub;
Button btnGo;
ArrayList<String> alCat;
ArrayAdapter<String> aaCat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCat = findViewById(R.id.textViewCat);
        tvSub = findViewById(R.id.textViewSub);
        spnCat = findViewById(R.id.spinnerCat);
        spnSub = findViewById(R.id.spinnerSub);
        btnGo = findViewById(R.id.buttonGo);


        alCat = new ArrayList<>();

        aaCat = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_dropdown_item , alCat);

        spnSub.setAdapter(aaCat);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor prefEdit = pref.edit();

        int Cat = pref.getInt("Cat" , 0);
        int Sub = pref.getInt("SOI" , 0);
        spnCat.setSelection(Cat);
        spnSub.setSelection(Sub);



        //prefEdit.getClass(");





        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

//                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
//                SharedPreferences.Editor prefEdit = pref.edit();
//                prefEdit.putInt("Cat" , i);
//                prefEdit.commit();
                switch(i){

                    case 0:


                        alCat.clear();
                        String[] strRP = getResources().getStringArray(R.array.spinner_RP);
                        alCat.addAll(Arrays.asList(strRP));
                        aaCat.notifyDataSetChanged();



                        break;



                    case 1:



                        alCat.clear();
                        String[] strSOI = getResources().getStringArray(R.array.spinner_SOI);
                        alCat.addAll(Arrays.asList(strSOI));
                        aaCat.notifyDataSetChanged();


                        break;



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





btnGo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        String [][] sites = {

                {"https://www.rp.edu.sg/" ,"https://www.rp.edu.sg/student-life" },{"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
        }

        };

        String url = sites[spnCat.getSelectedItemPosition()][spnSub.getSelectedItemPosition()];

        Intent intent = new Intent (getBaseContext() , URL.class);
        intent.putExtra("url" , url);
        startActivity(intent);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor prefEdit = pref.edit();
        prefEdit.putInt("Cat" , spnCat.getSelectedItemPosition());
        prefEdit.putInt("Sub" , spnSub.getSelectedItemPosition());
        prefEdit.commit();
      //  Intent intent = new Intent (getBaseContext() , URL.class);

//        int pos = spnCat.getSelectedItemPosition();
//
//
//        alCat.clear();
//        if(pos == 0){
//
//            String[] strRP = getResources().getStringArray(R.array.spinner_RP);
//            alCat.addAll(Arrays.asList(strRP));
//            aaCat.notifyDataSetChanged();
//
//            if(spnSub.getSelectedItemPosition() == 0){
//                Intent intent = new Intent(MainActivity.this , URL.class);
//                String url = "https://www.rp.edu.sg/";
//                intent.putExtra("url" , url);
//                startActivity(intent);
//
//            }
//
//            else if (spnSub.getSelectedItemPosition() == 1){
//
//                Intent intent = new Intent(MainActivity.this , URL.class);
//                String url = "https://www.rp.edu.sg/student-life";
//                intent.putExtra("url" , url);
//                startActivity(intent);
//
//            }
//
//
//        }
//
//        else{
//
//            String[] strSOI = getResources().getStringArray(R.array.spinner_SOI);
//            alCat.addAll(Arrays.asList(strSOI));
//            aaCat.notifyDataSetChanged();
//            Intent intent = new Intent(MainActivity.this , URL.class);
//            if(spnSub.getSelectedItemPosition() == 0){
//
//                String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
//                intent.putExtra("url" , url);
//                startActivity(intent);
//
//            }
//
//            else if (spnSub.getSelectedItemPosition() == 1){
//
//                String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r1";
//                intent.putExtra("url" , url);
//                startActivity(intent);
//            }
//
//        }

    }
});








    }
}
