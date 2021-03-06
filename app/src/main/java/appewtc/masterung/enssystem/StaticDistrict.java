package appewtc.masterung.enssystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StaticDistrict extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_district);
        //Create ListView
        String[] districtStrings = new  String[11];
        districtStrings = new String[11];
        districtStrings[0] = "อำเภอเมือง";
        districtStrings[1] = "อำเภอบางคล้า";
        districtStrings[2] = "อำเภอบางน้ำเปรี้ยว";
        districtStrings[3] = "อำเภอบางปะกง";
        districtStrings[4] = "อำเภอบ้านโพธิ์";
        districtStrings[5] = "อำเภอพนมสารคาม";
        districtStrings[6] = "อำเภอราชสาส์น";
        districtStrings[7] = "อำเภอสนามชัยเขต";
        districtStrings[8] = "อำเภอแปลงยาว";
        districtStrings[9] = "อำเภอท่าตะเกียบ";
        districtStrings[10] = "อำเภอคลองเขื่อน";

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, districtStrings);
        ListView listView = (ListView) findViewById(R.id.listView3);
                listView.setAdapter(stringArrayAdapter);
    }//
    public  void  clickBackStaticDistrict(View view){
        finish();
    }
}//
