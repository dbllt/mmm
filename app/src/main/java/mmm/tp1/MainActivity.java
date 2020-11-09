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

    private ActivityMainBinding binding;

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
        String s = "Nom : " + binding.nom.getText() + "\nPrénom : " + binding.prenom.getText() +
                "\nDate de naissance : " + binding.dateNaissance.getText() +
                "\nVille de naissance : " + binding.villeNaissance.getText();
        Toast.makeText(getApplicationContext(),
                s, Toast.LENGTH_SHORT).show();
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