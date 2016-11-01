package nougatstudio.knowledgefactor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by soura on 26-10-2016.
 */

public class AdapterClassForMainFragment extends RecyclerView.Adapter<AdapterClassForMainFragment.MyViewHolder>{

    private List<Data> DataList;

    public AdapterClassForMainFragment(List<Data> dataList) {
        this.DataList = dataList;
    }

    @Override
    public AdapterClassForMainFragment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_main_fragment, parent, false);
        return new AdapterClassForMainFragment.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(AdapterClassForMainFragment.MyViewHolder holder, int position) {

        Data data = DataList.get(position);
        holder.tittle.setText(data.getTechnologyName());

    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tittle;

        public MyViewHolder(View view) {
            super(view);
            tittle = (TextView) view.findViewById(R.id.tittle);
        }
    }
}
