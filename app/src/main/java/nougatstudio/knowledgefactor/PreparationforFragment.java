package nougatstudio.knowledgefactor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PreparationforFragment extends Fragment implements View.OnClickListener{


    View root;

    TextView startbtn,shareBtn;

    public PreparationforFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_preparationfor, container, false);

        getActivity().setTitle("Preparation For");

        startbtn = (TextView) root.findViewById(R.id.startBtn);
        shareBtn = (TextView) root.findViewById(R.id.shareBtn);

        startbtn.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {

        if (view == startbtn){

            ContentFragment contentFragment = new ContentFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragmentContainer_preparation_for, contentFragment).commit();
        }
        if (view == shareBtn){

        }
    }
}
