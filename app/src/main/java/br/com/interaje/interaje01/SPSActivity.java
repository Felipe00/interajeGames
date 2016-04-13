package br.com.interaje.interaje01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SPSActivity extends AppCompatActivity {

    private Button btnPaper, btnStone, btnScissors;
    private TextView title, cpuResponse, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sps);

        btnPaper = (Button) findViewById(R.id.paper);
        btnStone = (Button) findViewById(R.id.stone);
        btnScissors = (Button) findViewById(R.id.scissors);

        title = (TextView) findViewById(R.id.title_SPS_game);
        cpuResponse = (TextView) findViewById(R.id.cpuResult);
        result = (TextView) findViewById(R.id.result);

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pedra: 0, papel: 1, tesoura: 2
                verifyResponses(1);
            }
        });

        btnStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pedra: 0, papel: 1, tesoura: 2
                verifyResponses(0);
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pedra: 0, papel: 1, tesoura: 2
                verifyResponses(2);
            }
        });

    }

    private void verifyResponses(int personResponse) {
        int random = (int) (Math.floor(Math.random() * 3));

        switch (random) {
            // pedra: 0, papel: 1, tesoura: 2
            case 0:
                cpuResponse.setText(R.string.cpu_stone_response);
                if (personResponse == 0) {
                    // Igual
                    result.setText(R.string.same_result);
                } else if (personResponse == 1) {
                    // cpu perdeu
                    result.setText(R.string.you_win);
                } else {
                    // cpu ganhou
                    result.setText(R.string.you_lose);
                }
                break;
            case 1:
                cpuResponse.setText(R.string.cpu_paper_response);
                if (personResponse == 0) {
                    // cpu ganhou
                    result.setText(R.string.you_lose);
                } else if (personResponse == 1) {
                    // Igual
                    result.setText(R.string.same_result);
                } else {
                    // cpu perdeu
                    result.setText(R.string.you_win);
                }
                break;
            case 2:
                cpuResponse.setText(R.string.cpu_scissors_response);
                if (personResponse == 0) {
                    // cpu perdeu
                    result.setText(R.string.you_win);
                } else if (personResponse == 1) {
                    // cpu ganhou
                    result.setText(R.string.you_lose);
                } else {
                    // Igual
                    result.setText(R.string.same_result);
                }
                break;
        }
    }
}
