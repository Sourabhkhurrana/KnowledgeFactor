package nougatstudio.knowledgefactor;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragmentAddCategory extends Fragment {

    Button addCategoryButton;
    //EditText
    EditText addCategoryNameInput;
    View view;

    public AdminFragmentAddCategory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_admin_fragment_add_category, container, false);

        //EditText
        addCategoryNameInput = (EditText) view.findViewById(R.id.addCategoryNameInput);
        addCategoryButton = (Button) view.findViewById(R.id.addCategoryButton);
        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCategoryButtonWork();
            }
        });

        return view;
    }

    public boolean CheckAddCategoryControls() {
        Boolean status = true;
        if (addCategoryNameInput.getText().toString().trim().length() < 2) {
            status = false;
            Snackbar.make(view, "Must Enter Category Name !", Snackbar.LENGTH_SHORT).show();

        }
        return status;
    }

    public void AddCategoryButtonWork() {
        if (CheckAddCategoryControls()) {
            if (Utility.isOnline(getActivity())) {
                addCategoryButton.setEnabled(false);
                final DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();

                CategoryValues categoryValues;
                //aa.setCategoryName(addCategoryNameInput.getText().toString().trim());

                try {

                    mFirebaseDatabaseReference.child("CategoryList").child("" + addCategoryNameInput.getText().toString().trim()).child("categoryName").setValue(""+addCategoryNameInput.getText().toString().trim());
                    mFirebaseDatabaseReference.child("CategoryData").child("" + addCategoryNameInput.getText().toString().trim()).setValue(new CategoryValues(addCategoryNameInput.getText().toString().trim(),0));
                    addCategoryButton.setEnabled(true);
                    Snackbar.make(view, "Category Created Successfully !", Snackbar.LENGTH_LONG).show();
                    //resetAddCategoryValues();
                } catch (Exception e) {

                    Snackbar.make(view, "Network Problem !", Snackbar.LENGTH_LONG).show();
                    addCategoryButton.setEnabled(true);
                }


            } else {
                Snackbar.make(view, "No Internet Connection ", Snackbar.LENGTH_LONG).show();
            }
        }

    }

}
