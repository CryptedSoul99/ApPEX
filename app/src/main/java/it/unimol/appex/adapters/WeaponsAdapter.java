package it.unimol.appex.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
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
import it.unimol.appex.model.Weapon;

public class WeaponsAdapter extends RecyclerView.Adapter<WeaponsAdapter.WeaponItemHolder>{

    private List<Weapon> weapons;

    public WeaponsAdapter(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    @NonNull
    @NotNull
    @Override
    public WeaponsAdapter.WeaponItemHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new WeaponsAdapter.WeaponItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull WeaponsAdapter.WeaponItemHolder holder, int position) {
        Weapon weapon = weapons.get(position);
        holder.itemTitle.setText(weapon.getNameWeapon());
        holder.subtitle.setText(weapon.getFireModWeapon());

        String pureBase64Encoded = weapon.getImgWeapon().substring(weapon.getImgWeapon()
                .indexOf(",")  + 1);

            byte[] decodedString = Base64.decode(pureBase64Encoded, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            holder.imageItem.setImageBitmap(decodedByte);

    }

    @Override
    public int getItemCount() {
        return weapons.size();
    }


    public class WeaponItemHolder extends RecyclerView.ViewHolder {

        public TextView itemTitle;
        public TextView subtitle;
        public ImageView imageItem;


        public WeaponItemHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.itemTitle = itemView.findViewById(R.id.itemTitle);
            this.subtitle = itemView.findViewById(R.id.subtitle);
            this.imageItem = itemView.findViewById(R.id.image_item);
        }
    }
}
