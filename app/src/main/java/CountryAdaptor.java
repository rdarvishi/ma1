import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ma1.R;

import java.util.ArrayList;

public class CountryAdaptor extends ArrayAdapter<CountryItem> {

    public CountryAdaptor(@NonNull Context context, ArrayList<CountryItem> countrylist) {
        super(context,0, countrylist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_item,parent,false);
        }
        ImageView imageViewFlag = convertView.findViewById(R.id.flag_id);
        TextView textViewName = convertView.findViewById(R.id.cuntry_name_id);

        CountryItem currentItem = getItem(position);

        if (currentItem!=null){
            imageViewFlag.setImageResource(currentItem.getMflag());
            textViewName.setText(currentItem.getMname());
        }


        return convertView;
    }
}
