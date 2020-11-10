package mmm.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

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

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragment1InteractionListener, SecondFragment.OnFragment2InteractionListener {


    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public void onFragment1Interaction() {

        navController.navigate(R.id.action_mainFragment_to_secondFragment);

    }

    @Override
    public void onFragment2Interaction() {

        navController.navigate(R.id.action_secondFragment2_to_mainFragment2);

    }


}