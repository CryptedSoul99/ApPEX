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

public class HeirloomsAdapter extends RecyclerView.Adapter<HeirloomsAdapter.HeirloomItemHolder> {

    private List<Heirloom> heirlooms;

    public HeirloomsAdapter(List<Heirloom> heirlooms) {
        this.heirlooms = heirlooms;
    }

    @NonNull
    @NotNull
    @Override
    public HeirloomItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new HeirloomItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HeirloomItemHolder holder, int position) {
        Heirloom heirloom = heirlooms.get(position);
        holder.itemTitle.setText(heirloom.getNomeHeriloom());
        holder.subtitle.setText(heirloom.getIdLegends() + "");

        String pureBase64Encoded = heirloom.getImgHeirloom().substring(heirloom.getImgHeirloom()
                .indexOf(",")  + 1);

        byte[] decodedString = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        holder.imageItem.setImageBitmap(decodedByte);
    }

    @Override
    public int getItemCount() {
        return heirlooms.size();
    }

    public class HeirloomItemHolder extends RecyclerView.ViewHolder{

        public TextView itemTitle;
        public TextView subtitle;
        public ImageView imageItem;


        public HeirloomItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.itemTitle = itemView.findViewById(R.id.itemTitle);
            this.subtitle = itemView.findViewById(R.id.subtitle);
            this.imageItem = itemView.findViewById(R.id.image_item);
        }
    }
}


