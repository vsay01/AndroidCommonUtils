package me.com.androidcommonutils;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.com.androidutilslibrary.DialogUtils.DialogUtils;
import me.com.androidutilslibrary.NetworkUtils.NetworkUtils;

public class SampleActivity extends AppCompatActivity {

    @BindView(R.id.btnShowDialog)
    AppCompatButton btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils.buildDialog(SampleActivity.this, getString(R.string.welcome), getString(R.string.dialog_welcome_message), getString(R.string.ok)).show();
            }
        });

        if (NetworkUtils.isOnline(this)) {
            DialogUtils.buildDialog(SampleActivity.this, getString(R.string.welcome), getString(R.string.message_online), getString(R.string.ok)).show();
        } else {
            DialogUtils.buildDialog(SampleActivity.this, getString(R.string.welcome), getString(R.string.message_offline), getString(R.string.ok)).show();
        }
    }
}
