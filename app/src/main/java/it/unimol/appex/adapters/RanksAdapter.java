package it.unimol.appex.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import it.unimol.appex.R;
import it.unimol.appex.model.Heirloom;
import it.unimol.appex.model.Rank;

public class RanksAdapter extends RecyclerView.Adapter<RanksAdapter.RankItemHolder> {

    private List<Rank> ranks;

    public RanksAdapter(List<Rank> ranks) {
        this.ranks = ranks;
    }

    @NonNull
    @NotNull
    @Override
    public RanksAdapter.RankItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new RanksAdapter.RankItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RanksAdapter.RankItemHolder holder, int position) {
        Rank rank = ranks.get(position);
        holder.itemTitle.setText(rank.getLeagueRank());
        holder.subtitle.setText(rank.getEntryPointRank());

        String pureBase64Encoded = rank.getImgRank().substring(rank.getImgRank()
                .indexOf(",")  + 1);

        byte[] decodedString = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        holder.imageItem.setImageBitmap(decodedByte);
    }

    @Override
    public int getItemCount() {
        return ranks.size();
    }

    public class RankItemHolder extends RecyclerView.ViewHolder{

        public TextView itemTitle;
        public TextView subtitle;
        public ImageView imageItem;


        public RankItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.itemTitle = itemView.findViewById(R.id.itemTitle);
            this.subtitle = itemView.findViewById(R.id.subtitle);
            this.imageItem = itemView.findViewById(R.id.image_item);
        }
    }
}
