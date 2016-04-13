package br.com.interaje.interaje01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btnNumberGuessGame;
    private Button btnSPSGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnNumberGuessGame = (Button) findViewById(R.id.btnGuessGame);
        btnSPSGame = (Button) findViewById(R.id.btnStonePaperScissors);

        btnNumberGuessGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
                finish();
            }
        });

        btnSPSGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, SPSActivity.class));
                finish();
            }
        });
    }
}
