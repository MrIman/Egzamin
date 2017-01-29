package manka.igor.callreceiving;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SendSmsActivity extends AppCompatActivity {

    @BindView(R.id.number)
    EditText mNumberET;
    @BindView(R.id.editText)
    EditText mTextET;
    @BindView(R.id.send_button)
    Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        ButterKnife.bind(this);
        final SmsManager smsManager = SmsManager.getDefault();
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //**
                // potrzebne dla api > 23
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    ActivityCompat.requestPermissions(SendSmsActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);
                //**

                smsManager.sendTextMessage(mNumberET.getText().toString(), null, mTextET.getText().toString(), null, null);
                Toast.makeText(SendSmsActivity.this, "Wysłano", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
