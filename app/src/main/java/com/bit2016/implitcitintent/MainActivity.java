package com.bit2016.implitcitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflate
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_call).setOnClickListener(this);
        findViewById(R.id.button_address).setOnClickListener(this);
        findViewById(R.id.button_web).setOnClickListener(this);
        findViewById(R.id.button_search).setOnClickListener(this);
        findViewById(R.id.button_map).setOnClickListener(this);
        findViewById(R.id.button_share).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {
            case R.id.button_call:{
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-2343-3344"));
                startActivity(intent);
                break;
        }
            case R.id.button_address : {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(Uri.parse("content://com.android.contacts/data/phones"));
                startActivity(intent);
                break;
            }
            case R.id.button_web : {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
                break;
            }
            case R.id.button_search : {
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.android.browser");
                intent.putExtra("query", "android");
                startActivity(intent);
                break;
            }
            case R.id.button_map : {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:38.899533,-77.036476"));
                startActivity(intent);
                break;
            }

            case R.id.button_share : {
                Intent intent = new Intent("com.bit2016.android.action.ACTION_SHARE");
                startActivity(intent);
                break;
            }
            default:
                Toast.makeText(this, "unknown view", Toast.LENGTH_LONG).show();

        }
    }
}
