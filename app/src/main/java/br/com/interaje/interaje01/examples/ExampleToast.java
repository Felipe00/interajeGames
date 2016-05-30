package br.com.interaje.interaje01.examples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import br.com.interaje.interaje01.R;

/**
 * Created by rayquaza on 18/04/16.
 */
public class ExampleToast extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_toast);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Passei pelo onStart", Toast.LENGTH_SHORT).show();
    }

}
