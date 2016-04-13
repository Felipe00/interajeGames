package br.com.interaje.interaje01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private EditText numberGuess;
    private Button confirm;
    private Button newGame;
    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        numberGuess = (EditText) findViewById(R.id.numberGuess);
        confirm = (Button) findViewById(R.id.btnConfirm);
        newGame = (Button) findViewById(R.id.newGame);
        randomNumber = (int) (Math.random() * 10);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int personGuess = Integer.parseInt(numberGuess.getText().toString());

                if (personGuess > randomNumber) {
                    //Diz que o número é alto;
                    title.setText("O número que pensei é menor");
                } else if (personGuess < randomNumber) {
                    // Diz que o número é menor;
                    title.setText("O número que pensei é maior");
                } else {
                    // Diz que acertou!
                    title.setText("Parabéns! Acertou!");
                }
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText(R.string.title);
                numberGuess.setText("");
            }
        });
    }
}
