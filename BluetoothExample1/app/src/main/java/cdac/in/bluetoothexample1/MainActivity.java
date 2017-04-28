package cdac.in.bluetoothexample1;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvBtstatus;
    Button getbtOn, getbtDiscover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvBtstatus = (TextView) findViewById(R.id.tvbthStat);
        getbtOn = (Button) findViewById(R.id.btOn);
        getbtDiscover = (Button) findViewById(R.id.btDiscv);

        getbtOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
               // tvBtstatus.setText("Bluetooth is On");
                startActivityForResult(intent,111);
            }
        });

        getbtDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(intent,222);
            }
        });
    }

    BroadcastReceiver bthRecv = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 111 && resultCode == RESULT_OK)
        {
            getbtOn.setVisibility(View.GONE);
            tvBtstatus.setText("Bluetooth io On");
        }
        if(requestCode == 222)
        {
            tvBtstatus.setText("Bluetooth is Now discoverable");
        }
    }


}
