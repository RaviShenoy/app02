package apps.myapp.com.app02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;
import android.view.View;

public class MyActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.app02.myactivity.Message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent moveToSettings = new Intent(this, Settings_activity.class);
            startActivity(moveToSettings);
            return true;
        }
        if (id == R.id.action_search) {
            Intent openSearch = new Intent(this, Search.class);
            startActivity(openSearch);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String editMessage = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, editMessage);
        startActivity(intent);
    }
    public void recordVoice(View view){
        Intent intent = new Intent(this, RecordMessageActivity.class);

        startActivity(intent);
    }

    public void blueToothFunc(View view){
        Intent intent = new Intent(this, BluetoothMenu.class);
        startActivity(intent);
    }
}
