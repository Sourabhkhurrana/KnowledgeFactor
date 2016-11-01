package nougatstudio.knowledgefactor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InstructionFragment extends Fragment {


    View root;
    public InstructionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_instruction, container, false);
        LinearLayout proceedBtnInstruction = (LinearLayout) root.findViewById(R.id.proceedBtnInstruction);
        getActivity().setTitle("Instruction");
        //getFragmentManager().popBackStack();

        proceedBtnInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Go Went Gone", Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }

}
