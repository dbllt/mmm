package mmm.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import mmm.tp1.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String nom = intent.getStringExtra(MainActivity.EXTRA_NOM);
        String prenom = intent.getStringExtra(MainActivity.EXTRA_PRENOM);
        String date = intent.getStringExtra(MainActivity.EXTRA_DATE);
        String ville = intent.getStringExtra(MainActivity.EXTRA_VILLE);

        TextView nomView = findViewById(R.id.nom);
        TextView prenomView = findViewById(R.id.prenom);
        TextView dateView = findViewById(R.id.dateNaissance);
        TextView villeView = findViewById(R.id.villeNaissance);


        nomView.setText(nom);
        prenomView.setText(prenom);
        dateView.setText(date);
        villeView.setText(ville);

    }
}