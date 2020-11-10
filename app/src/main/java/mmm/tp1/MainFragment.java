package mmm.tp1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainFragment extends Fragment {


    private SharedInfoVM myData;

    private OnFragment1InteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myData = new ViewModelProvider(requireActivity()).get(SharedInfoVM.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        v.findViewById(R.id.valider).setOnClickListener(this::onClickValider);

        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
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

    public void menuItemClear() {
        Toast.makeText(getActivity(), "allo", Toast.LENGTH_SHORT).show();
        ((EditText) getView().findViewById(R.id.nom)).setText("");
        ((EditText) getView().findViewById(R.id.prenom)).setText("");
        ((EditText) getView().findViewById(R.id.dateNaissance)).setText("");
        ((EditText) getView().findViewById(R.id.villeNaissance)).setText("");
    }


    public void menuItemTelephone() {
        ConstraintLayout layout = (ConstraintLayout) getView().findViewById(R.id.myLayout);
        EditText telephone = new EditText(getContext());
        telephone.setHint("Téléphone");
        telephone.setInputType(InputType.TYPE_CLASS_PHONE);

        layout.addView(telephone);
    }

    public void menuItemBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/" +
                ((Spinner) getView().findViewById(R.id.spinner)).getSelectedItem().toString()));
        startActivity(intent);
    }

    public void onClickValider(View view) {

        String nom = ((EditText) getView().findViewById(R.id.nom)).getText().toString();
        String prenom = ((EditText) getView().findViewById(R.id.prenom)).getText().toString();
        String date = ((EditText) getView().findViewById(R.id.dateNaissance)).getText().toString();
        String ville = ((EditText) getView().findViewById(R.id.villeNaissance)).getText().toString();

        if (mListener != null) {
            myData.setdata(new UserInfo(nom, prenom, date, ville));

            mListener.onFragment1Interaction();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment1InteractionListener) {
            mListener = (OnFragment1InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragment1InteractionListener {
        void onFragment1Interaction();
    }
}