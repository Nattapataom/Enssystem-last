package appewtc.masterung.enssystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class CallListView extends AppCompatActivity {

    //Explicit
    private ImageView cat0ImageView, cat1ImageView,cat2ImageView,
            cat3ImageView,cat4ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_list_view);

        //Bind Widget
    bindWidget();

    }//Main Method

    private  void bindWidget(){
        cat0ImageView = (ImageView)findViewById(R.id.imageView10);
        cat1ImageView = (ImageView)findViewById(R.id.imageView11);
        cat2ImageView = (ImageView)findViewById(R.id.imageView12);
        cat3ImageView = (ImageView)findViewById(R.id.imageView13);
        cat4ImageView = (ImageView)findViewById(R.id.imageView14);



    }
}//Main Class
