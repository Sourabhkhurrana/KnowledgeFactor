package nougatstudio.knowledgefactor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {


    View root;
    LinearLayout proceedBtnContent;
    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_content, container, false);
        //getFragmentManager().popBackStack();
        getActivity().setTitle("Content");

        proceedBtnContent = (LinearLayout) root.findViewById(R.id.proceedBtnContent);
        proceedBtnContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InstructionFragment instructionFragment = new InstructionFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer_preparation_for,instructionFragment).commit();
            }
        });

        return root;
    }

}
