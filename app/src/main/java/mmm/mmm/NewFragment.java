package mmm.mmm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import androidx.lifecycle.Observer;

public class NewFragment extends Fragment implements UserAdapter.UserAdapterListener {

    private RecyclerView recyclerView;
    private UserAdapter mAdapter;
    private NewFragment.OnNewFragmentInteractionListener mListener;

    public NewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new, container, false);

        v.findViewById(R.id.button).setOnClickListener(this::nouveauClient);


        recyclerView = v.findViewById(R.id.recyclerView);
        final UserAdapter mAdapter = new UserAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);


        ((MainActivity) getActivity()).viewModel.getAllUsers().observe(getActivity(), new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                mAdapter.setUsers(users);
            }
        });

        return v;
    }


    public void nouveauClient(View view) {

        if (mListener != null) {

            mListener.onNewFragmentInteraction();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragment.OnFragment1InteractionListener) {
            mListener = (NewFragment.OnNewFragmentInteractionListener) context;
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

    @Override
    public void onUserSelected(User user) {
        Toast.makeText(getContext(), "Selected: " + user.nom, Toast.LENGTH_LONG).show();
    }

    public interface OnNewFragmentInteractionListener {
        void onNewFragmentInteraction();
    }
}