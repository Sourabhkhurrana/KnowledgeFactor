package nougatstudio.knowledgefactor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by soura on 26-10-2016.
 */

public class AdapterClassForHomeFragment extends RecyclerView.Adapter<AdapterClassForHomeFragment.MyViewHolder>{

    private List<Data> DataList;

    public AdapterClassForHomeFragment(List<Data> dataList) {
        this.DataList = dataList;
    }

    @Override
    public AdapterClassForHomeFragment.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_layout_catagories, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(AdapterClassForHomeFragment.MyViewHolder holder, int position) {

        Data data = DataList.get(position);
        holder.categoryName.setText(data.getCategoryName());
        holder.categoryImage.setImageResource(data.getCategoriesImages());
        holder.recyclerCategoryLayout.setBackgroundResource(data.CategoryColor[position]);
    }

    @Override
    public int getItemCount() {
        return DataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView categoryName;
        public ImageView categoryImage;
        public RelativeLayout recyclerCategoryLayout;

        public MyViewHolder(View view) {
            super(view);
            categoryName = (TextView) view.findViewById(R.id.categoryName);
            categoryImage = (ImageView) view.findViewById(R.id.categoryImage);
            recyclerCategoryLayout = (RelativeLayout) view.findViewById(R.id.recyclerCategoryLayout);
        }
    }
}
