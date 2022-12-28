package com.example.blog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutUs extends AppCompatActivity {

    private DrawerLayout drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        drawerlayout = findViewById(R.id.drawerlayout);
        Button btnFacebook = findViewById(R.id.btnFacebook);
        Button btnFacebook2 = findViewById(R.id.btnFacebook2);
        Button btnFacebook3 = findViewById(R.id.btnFacebook3);
        Button btnEmail = findViewById(R.id.btnEmail);
        Button btnEmail2 = findViewById(R.id.btnEmail2);
        Button btnEmail3 = findViewById(R.id.btnEmail3);
        Button brnphone = findViewById(R.id.btnphone);
        Button brnphone2 = findViewById(R.id.btnphone2);
        Button brnphone3 = findViewById(R.id.btnphone3);

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://www.facebook.com/maha.grindi.98/");
            }
        });

        btnFacebook2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://www.facebook.com/yosra.wanene");
            }
        });

        btnFacebook3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotUrl("https://www.facebook.com/ach02raf");
            }
        });




        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail("grindi.maha@Gmail.com");
            }
        });
        btnEmail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail("yosrawanne28@Gmail.com");
            }
        });
        btnEmail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail("ach02raf@Gmail.com");
            }
        });

        brnphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call("562180004");
            }
        });
        brnphone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call("50222142");
            }
        });

        brnphone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call("56218777");
            }
        });


    }

    private void sendEmail(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_TEXT ,"Address:"+s );
        startActivity(intent);
    }

    private void gotUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
    private void call(String s) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+s));
        startActivity(intent);
    }


    public void  ClickMenu(View view){
        //Open dramer
        openDrawer(drawerlayout);
    }

    private void openDrawer(DrawerLayout drawerlayout) {
        // Open drawer layout
        drawerlayout.openDrawer(GravityCompat.START);
    }

    public void  ClickLogo(View view){
        //Recreate activity
        Home.CloseDrawer(drawerlayout);
    }



    public void  ClickHome(View view){
        //Recreate activity
        AboutUs.this.finish();
        Home.redirectActivity(this , Home.class);
    }



    public void  ClickProfile (View view){
        //Redirect activity to dashbord
        AboutUs.this.finish();

        Home.redirectActivity(this , Profile.class);

    }


    public void  ClickAdboutUS (View view){
        //Redirect activity to dashbord
        AboutUs.this.finish();

        Home.redirectActivity(this , AboutUs.class);

    }

    public void  LogOut (View view){
        AboutUs.this.finish();

        Home.Logouts(this);

    }


}