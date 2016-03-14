package appewtc.masterung.enssystem;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewDetail extends AppCompatActivity implements View.OnClickListener {
    //Explicit
    private TextView titlTextView, dateTextView, detaTextView;
        private ImageView newsImageView;
    private  String titleString, dateString, detailString, urlNewsImageString, videoString;
    private Button backButton, videoButton;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_detail);

        //Bind Widget
        bindWidget();

        showView();
        
        //Button
        buttonController();





}//Main Method

    private void buttonController() {
        backButton.setOnClickListener(this);
        videoButton.setOnClickListener(this);
    }

    private  void showView(){
        //Receive Value From Intent
        titleString = getIntent().getStringExtra("Title");
        urlNewsImageString = getIntent().getStringExtra("Image");
        dateString   =getIntent().getStringExtra("Date");
        detailString = getIntent().getStringExtra("Detail");


        titlTextView.setText(titleString);
        dateTextView.setText(dateString);
        detaTextView.setText(detailString);

        Picasso.with(NewDetail.this)
                .load(urlNewsImageString)
                .resize(250, 125)
                .into(newsImageView);

    }//showView

    private void bindWidget() {

        titlTextView = (TextView) findViewById(R.id.txtTitleNewsDetail);
        dateTextView =(TextView)findViewById(R.id.txtDay);
        detaTextView = (TextView)findViewById(R.id.txtDetail);
        newsImageView = (ImageView) findViewById(R.id.imvDetail);
        backButton = (Button) findViewById(R.id.bttDetailBack);
        videoButton = (Button) findViewById(R.id.bttDetailVideo);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bttDetailBack:
                finish();
                break;
            case  R.id.bttDetailVideo:
        showVideoView();


                break;
        }//swith
    }//onClick

    private void showVideoView() {
        videoString = getIntent().getStringExtra("Video");
        if (videoString.length() !=0) {
            //Have Value
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(videoString));
            startActivity(intent);
        }else{
            //Null
            MyAlertDialog myAlertDialog = new MyAlertDialog();
            myAlertDialog.MyDialog(NewDetail.this, R.drawable.icon_question,
                    "ไม่สามารถแสดง วีดิโอได้", "ไม่สามารถแสดง วีดีโอได้ เนื่องด้วยข่าวนี้ไม่มีวีดีโอค่ะ" );
        }


    }//showVideo


} //Main Class
