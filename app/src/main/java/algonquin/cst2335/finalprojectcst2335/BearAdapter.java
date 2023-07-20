package algonquin.cst2335.finalprojectcst2335;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BearAdapter extends RecyclerView.Adapter<BearAdapter.BearViewHolder> {

    private List<BearItem> bearList;

    public BearAdapter(List<BearItem> bearList) {
        this.bearList = bearList;
    }

    // Create a ViewHolder to hold the views for one item in the RecyclerView
    public static class BearViewHolder extends RecyclerView.ViewHolder {
        public TextView bearNameTextView;

        public BearViewHolder(View itemView) {
            super(itemView);
            bearNameTextView = itemView.findViewById(R.id.bearNameTextView);
        }
    }

    // Inflate the item layout and create a ViewHolder
    @NonNull
    @Override
    public BearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bear, parent, false);
        return new BearViewHolder(itemView);
    }

    // Bind the data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull BearViewHolder holder, int position) {
        BearItem bearItem = bearList.get(position);
        holder.bearNameTextView.setText(bearItem.getName());
    }

    // Return the number of items in the RecyclerView
    @Override
    public int getItemCount() {
        return bearList.size();
    }
}

