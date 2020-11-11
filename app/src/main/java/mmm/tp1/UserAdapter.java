package mmm.tp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context context;
    public List<User> userList;
    public List<User> userListFiltered;
    private UserAdapterListener listener;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nom, prenom, date, ville;

        public MyViewHolder(View view) {
            super(view);
            nom = view.findViewById(R.id.nomm);
            prenom = view.findViewById(R.id.prenomm);
            date = view.findViewById(R.id.datee);
            ville = view.findViewById(R.id.villee);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onUserSelected(userListFiltered.get(getAdapterPosition()));

                }
            });

        }
    }

    public UserAdapter(Context context, List<User> contactList, UserAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.userList = contactList;
        this.userListFiltered = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final User user = userListFiltered.get(position);
        holder.nom.setText(user.nom);
        holder.prenom.setText(user.prenom);
        holder.date.setText(user.date);
        holder.ville.setText(user.ville);


    }

    @Override
    public int getItemCount() {
        return userListFiltered.size();
    }


    public interface UserAdapterListener {
        void onUserSelected(User user);
    }
}

