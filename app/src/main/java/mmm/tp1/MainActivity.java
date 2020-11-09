package mmm.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mmm.tp1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NOM = "mmm.tp1.nom";
    public static final String EXTRA_PRENOM = "mmm.tp1.prenom";
    public static final String EXTRA_DATE = "mmm.tp1.date";
    public static final String EXTRA_VILLE = "mmm.tp1.ville";
    private ActivityMainBinding binding;


    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear:
                menuItemClear();
                return true;
            case R.id.telephone:
                menuItemTelephone();
                return true;
            case R.id.browser:
                menuItemBrowser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onClickValider(View view) {
        /**
         Intent intent = new Intent(this, SecondActivity.class);
         intent.putExtra(EXTRA_NOM, binding.nom.getText());
         intent.putExtra(EXTRA_PRENOM, binding.prenom.getText());
         intent.putExtra(EXTRA_DATE, binding.dateNaissance.getText());
         intent.putExtra(EXTRA_VILLE, binding.villeNaissance.getText());
         startActivity(intent);
         **/
        Intent intent = new Intent(this, SecondActivity.class);

        EditText nom = (EditText) findViewById(R.id.nom);
        String messageNom = nom.getText().toString();
        intent.putExtra(EXTRA_NOM, messageNom);

        EditText prenom = (EditText) findViewById(R.id.prenom);
        String messagePrenom = prenom.getText().toString();
        intent.putExtra(EXTRA_PRENOM, messagePrenom);

        EditText date = (EditText) findViewById(R.id.dateNaissance);
        String messageDate = date.getText().toString();
        intent.putExtra(EXTRA_DATE, messageDate);

        EditText ville = (EditText) findViewById(R.id.villeNaissance);
        String messageVille = ville.getText().toString();
        intent.putExtra(EXTRA_VILLE, messageVille);

        startActivity(intent);


    }

    public void menuItemClear() {
        binding.nom.setText("");
        binding.prenom.setText("");
        binding.dateNaissance.setText("");
        binding.villeNaissance.setText("");
    }


    public void menuItemTelephone() {
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.myLayout);
        EditText telephone = new EditText(this);
        telephone.setHint("Téléphone");
        telephone.setInputType(InputType.TYPE_CLASS_PHONE);

        layout.addView(telephone);
    }

    public void menuItemBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/" + binding.spinner.getSelectedItem().toString()));
        startActivity(intent);
    }


}