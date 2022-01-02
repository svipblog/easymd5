package dev.svip.easymd5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import dev.svip.easymd5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'easymd5' library on application startup.
    static {
        System.loadLibrary("easymd5");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(mdString("blog.svip.dev"));
    }

    /**
     * A native method that is implemented by the 'easymd5' native library,
     * which is packaged with this application.
     */
    /**
     * Calculate md5 of a String
     * @param string The string
     * @return md5, or null if any error occurs.
     */
    public native String mdString(String string);

    /**
     * Calculate md5 of a File
     * @param filename The full path of the file
     * @return md5, or null if any error occurs.
     */
    public native String mdFile(String filename);

}