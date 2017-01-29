package manka.igor.callreceiving;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmsMessageActivity extends AppCompatActivity {

    @BindView(R.id.number)
    TextView mNumber;
    @BindView(R.id.message)
    TextView mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_message);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mNumber.setText(intent.getStringExtra("NUMBER"));
        mMessage.setText(intent.getStringExtra("MESSAGE"));
    }
}
