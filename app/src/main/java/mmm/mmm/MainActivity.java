package mmm.mmm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import mmm.mmm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragment1InteractionListener, SecondFragment.OnFragment2InteractionListener, NewFragment.OnNewFragmentInteractionListener {


    public ViewModel viewModel;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        viewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModel.class);



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


    @Override
    public void onNewFragmentInteraction() {


        navController.navigate(R.id.action_newFragment_to_mainFragment);
    }
}