package mmm.tp1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private OnFragment2InteractionListener mListener;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_second, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedInfoVM model = new ViewModelProvider(requireActivity()).get(SharedInfoVM.class);
        model.getData().observe(getViewLifecycleOwner(), data -> {

            ((TextView) view.findViewById(R.id.nom)).setText(data.nom);
            ((TextView) view.findViewById(R.id.prenom)).setText(data.prenom);
            ((TextView) view.findViewById(R.id.dateNaissance)).setText(data.date);
            ((TextView) view.findViewById(R.id.villeNaissance)).setText(data.ville  );
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2InteractionListener) {
            mListener = (OnFragment2InteractionListener) context;
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


    public interface OnFragment2InteractionListener {
        void onFragment2Interaction();
    }
}