package manka.igor.callreceiving;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallReceiver extends BroadcastReceiver {

    static boolean isRinging = false;
    static boolean isReceived = false;
    static String callerPhoneNumber;

    @Override
    public void onReceive(Context mContext, Intent intent) {

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);


        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            isRinging = true;
            Bundle bundle = intent.getExtras();
            callerPhoneNumber = bundle.getString("incoming_number");
        }

        if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            isReceived = true;
        }

        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            // detect missed call
            if (isRinging == true && isReceived == false) {
                Toast.makeText(mContext, "Nie odebrano : " + callerPhoneNumber, Toast.LENGTH_LONG).show();
                final SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(callerPhoneNumber, null, "Oddzwonię później", null, null);

            }
        }
    }
}
