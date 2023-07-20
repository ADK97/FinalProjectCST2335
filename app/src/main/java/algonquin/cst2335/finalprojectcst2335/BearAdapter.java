package algonquin.cst2335.finalprojectcst2335;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BearAdapter extends RecyclerView.Adapter<BearAdapter.BearViewHolder> {

    private List<BearItem> bearList;
    private ImageView bearImageView; // Reference to the ImageView in MainActivity

    public BearAdapter(List<BearItem> bearList, ImageView bearImageView) {
        this.bearList = bearList;
        this.bearImageView = bearImageView;
    }

    public static class BearViewHolder extends RecyclerView.ViewHolder {
        public TextView bearTypeTextView;

        public BearViewHolder(View itemView) {
            super(itemView);
            bearTypeTextView = itemView.findViewById(R.id.bearNameTextView);
        }
    }

    @NonNull
    @Override
    public BearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bear, parent, false);
        return new BearViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BearViewHolder holder, int position) {
        BearItem bearItem = bearList.get(position);
        holder.bearTypeTextView.setText(bearItem.getName());

        // using a bear png file as a placeholder, change to url later
        bearImageView.setImageResource(R.drawable.bear_image_placeholder);
    }

    @Override
    public int getItemCount() {
        return bearList.size();
    }
}
