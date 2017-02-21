package cz.matej.app.appforhelmut.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cz.matej.app.appforhelmut.R;
import cz.matej.app.appforhelmut.model.Example;

/**
 * Created by Fanda on 16.12.2016.
 */
public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Example> userModel;

    public UserAdapter(final List<Example> userModel) {
        this.userModel = userModel;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        return new UserAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof UserAdapterViewHolder)
        {

            ((UserAdapterViewHolder) holder).bind(this.userModel.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return this.userModel.size();
    }

    private static class UserAdapterViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mUserName;

        public UserAdapterViewHolder(View itemView) {
            super(itemView);
            this.mUserName = (TextView) itemView.findViewById(R.id.fileName);
        }

        void bind(final Example example)
        {
            this.mUserName.setText(example.getName());
        }
    }



}
