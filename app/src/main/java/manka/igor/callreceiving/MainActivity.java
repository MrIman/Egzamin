package manka.igor.callreceiving;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.call)
    Button mCall;
    @BindView(R.id.send_sms)
    Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addPermisions();
        mCall.setOnClickListener(this);
        mSend.setOnClickListener(this);
        IncomingSMS incomingSMS = new IncomingSMS();

    }

    private void addPermisions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE},
                1);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.call:
                intent = new Intent(MainActivity.this, CallActivity.class);
                break;
            case R.id.send_sms:
                intent = new Intent(MainActivity.this, SendSmsActivity.class);
                break;
        }
        startActivity(intent);
    }
}
