package cdac.in.bluetoothexample2;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button btOn,btOff,btList,btFind;
    BluetoothAdapter bluetoothAdapter;
    TextView tvStatus;
    ListView lvDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = (TextView) findViewById(R.id.tvBtStatus);
        lvDevice = (ListView) findViewById(R.id.lvbtdevices);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter(); //Initialising Bluetooth Adapter
    }

    public void On(View v)
    {
        if(bluetoothAdapter.isEnabled())
        {
            tvStatus.setText("Bluetooth is Already On!!!");
        }
        else
        {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent,111);
        }

    }
    public void Off(View v)
    {
        if(bluetoothAdapter.isEnabled())
        {
            bluetoothAdapter.disable();
            tvStatus.setText("Bluetooth is now Off");
        }
        else
            tvStatus.setText("Bluetooth is now Off");
    }

    public void Find(View v)
    {

    }
    public void List(View v)
    {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 111 && resultCode == RESULT_OK)
        {
            tvStatus.setText("Bluetooth is Now On!!");
        }
    }
}
