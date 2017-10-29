package empire.m.room;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";
    CoinDTO coinDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        coinDTO = new CoinDTO();
        coinDTO.uid = 0;
        coinDTO.name = "BTC";
        coinDTO.value = new BigDecimal(5400).toString();
        coinDTO.volume = new BigDecimal(1123123000).toString();
        coinDTO.balance = new BigDecimal(1.5784).toString();
        coinDTO.expPrice = new BigDecimal(6300).toString();
        fab.setOnClickListener(view -> {
            List<CoinDTO> coinDTOS = AppDatabase.getInstance(view.getContext().getApplicationContext()).coinDao()
                    .getDTO();
            if (coinDTOS != null && !coinDTOS.isEmpty()) {
                for (CoinDTO item : coinDTOS) {
                    Log.d(TAG, "item : " + item.uid + " " + item.name + " " + item.value + " " + item
                            .volume + " " + item.balance + " " + item.expPrice);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppDatabase.getInstance(getApplicationContext()).coinDao().insertCoinDTO(coinDTO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
