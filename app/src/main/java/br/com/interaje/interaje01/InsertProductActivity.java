package br.com.interaje.interaje01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class InsertProductActivity extends AppCompatActivity {

    private EditText productName, productPrice, categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_product);

        productName = (EditText) findViewById(R.id.productName);
        productPrice = (EditText) findViewById(R.id.productPrice);
        categoryName = (EditText) findViewById(R.id.productCategory);
    }

}
