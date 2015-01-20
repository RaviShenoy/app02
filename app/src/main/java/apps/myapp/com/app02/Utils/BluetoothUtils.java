package apps.myapp.com.app02.Utils;

import android.widget.ArrayAdapter;

/**
 * Created by Ravindra on 1/19/2015.
 */
public class BluetoothUtils {
    public ArrayAdapter<String> getArrayAdapter() {
        return arrayAdapter;
    }

    public static void setArrayAdapter(ArrayAdapter<String> pArrayAdapter) {
        arrayAdapter = pArrayAdapter;
    }

    static ArrayAdapter<String> arrayAdapter;
}
