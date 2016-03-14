package appewtc.masterung.enssystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class NewListView extends AppCompatActivity {


    //Explicit
    private ListView newListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list_view);

        //Bind Widdget
        newListView = (ListView) findViewById(R.id.listView);
        //Create ListView
        createListView();




    }//Main Method

    private void createListView() {
        //Read All Data from SQLite
        int intDigit = 30; //จำนวนตัวอักษรที่จะอ่านมาแสดงที่ Title

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ManageTABLE.TABLE_newsTABLE, null);
        cursor.moveToFirst();

        int intCount =  cursor  .getCount();
        final String[] titleFullStrings = new  String[intCount];
        String[] titleShortStrings = new String[intCount];
        final String[] dateStrings = new String[intCount];
        final String[] photoNewStrings = new  String[intCount];
        final String[] detailStrings = new String[intCount];
        final String[] videoStrings = new String[intCount];





        for (int i = 0; i < intCount; i++) {
            titleFullStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Title_News));
            dateStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Day_News));
            photoNewStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Photo_News));
            detailStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Detail_News));
            videoStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.COLUMN_Video_News));

            titleShortStrings[i] = titleFullStrings[i].substring(0, intDigit)+"...";
            cursor.moveToNext();
        }//for
        cursor.close();
         NewsAdapter newsAdapter = new NewsAdapter(NewListView.this,
                 titleShortStrings, dateStrings, photoNewStrings);
        newListView.setAdapter(newsAdapter);


        newListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(NewListView.this, NewDetail.class);
                intent.putExtra("Title", titleFullStrings[i]);
                intent.putExtra("image", photoNewStrings[i]);
                intent.putExtra("date", dateStrings[i]);
                intent.putExtra("detail", detailStrings[i]);
                intent.putExtra("video", videoStrings[i]);


                startActivity(intent);


            }   //onItemClick
        });



        }//createListView


    public void clickBackNewsList(View view) {
         finish();
    }


}// Main Class
