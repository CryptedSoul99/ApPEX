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
import it.unimol.appex.model.Legend;

public class LegendsAdapter extends RecyclerView.Adapter<LegendsAdapter.LegendItemHolder>{

    private List<Legend> legends;
    private OnLegendListner listner;

    public LegendsAdapter(List<Legend> legends, OnLegendListner listner) {
        this.legends = legends;
        this.listner = listner;
    }

    @NonNull
    @NotNull
    @Override
    public LegendItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new LegendsAdapter.LegendItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent,false), this.listner);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LegendItemHolder holder, int position) {
        Legend legend = legends.get(position);
        holder.itemTitle.setText(legend.getNameLegend());
        holder.subtitle.setText(legend.getUltimateLegend());

        String pureBase64Encoded = legend.getImgLegends().substring(legend.getImgLegends()
                .indexOf(",")  + 1);

        byte[] decodedString = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        holder.imageItem.setImageBitmap(decodedByte);
    }

    @Override
    public int getItemCount() {
        return legends.size();
    }

    public interface OnLegendListner{
        void onLegendClick(Legend legend, int position);
    }

    public class LegendItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView itemTitle;
        public TextView subtitle;
        public ImageView imageItem;
        public OnLegendListner onLegendListner;


        public LegendItemHolder(@NonNull @NotNull View itemView, OnLegendListner onLegendListner) {
            super(itemView);
            this.itemTitle = itemView.findViewById(R.id.itemTitle);
            this.subtitle = itemView.findViewById(R.id.subtitle);
            this.imageItem = itemView.findViewById(R.id.image_item);
            this.onLegendListner = onLegendListner;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onLegendListner.onLegendClick(legends.get(getAdapterPosition()), getAdapterPosition());
        }
    }
}