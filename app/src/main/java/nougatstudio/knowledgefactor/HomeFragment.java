package nougatstudio.knowledgefactor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    View view;
    //private List<Data> DataList = new ArrayList<>();
    //private AdapterClassForHomeFragment mAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        //RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_catagory);
        //mAdapter = new AdapterClassForHomeFragment(DataList);

        //final RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        //recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setAdapter(mAdapter);
        //prepareData();

        return view;
    }

//    public void prepareData(){
//
//        final DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
//        Query query  = mFirebaseDatabaseReference.child("CategoryList").orderByChild("CategoryList");
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot child : dataSnapshot.getChildren()) {
//                    Data value = child.getValue(Data.class);
//                    Log.e("Add Question details", "" + value);
//                    DataList.add(value);
//                    //addSetNoOfSetsAvaliable.setText("Number Of SubCategory :    " + value);
//                }
//                mAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//
//    }
}
