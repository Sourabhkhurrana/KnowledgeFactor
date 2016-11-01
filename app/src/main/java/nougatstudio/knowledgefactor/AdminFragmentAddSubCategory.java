package nougatstudio.knowledgefactor;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragmentAddSubCategory extends Fragment {

    Button addSubCategoryButton;
    EditText addSubCategoryNameInput;
    Spinner subCategoryListSpinner;
    String availableSubCategories;
    TextView noOfSubCategoryHave;
    View view;

    //Spinner Adapter
    ArrayAdapter<String> subCategoryListAdapter;
    //Spinner List
    List<String> CategoryList = new ArrayList<String>();

    public AdminFragmentAddSubCategory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_admin_fragment_add_sub_category, container, false);

        addSubCategoryNameInput = (EditText) view.findViewById(R.id.subCategoryName);
        addSubCategoryButton = (Button) view.findViewById(R.id.addSubCategoryButton);
        subCategoryListSpinner = (Spinner) view.findViewById(R.id.subCategoryListSpinner);
        noOfSubCategoryHave = (TextView) view.findViewById(R.id.noOfSubCategoryHave);

        subCategoryListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position > 0) {
                    NoOfSubCategoryHave();
                } else {
                    noOfSubCategoryHave.setText("Number Of SubCategory :    ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        addSubCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddSubCategoryButtonWork();
            }
        });

        OnLoad();
        SelectCategory();
        return view;
    }

    public void OnLoad() {
        CategoryList.clear();
        CategoryList.add("Select Category");
        subCategoryListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, CategoryList);
        subCategoryListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subCategoryListSpinner.setAdapter(subCategoryListAdapter);

    }

    public boolean CheckAddCategoryControls() {
        Boolean status = true;
        if (addSubCategoryNameInput.getText().toString().trim().length() < 2) {
            status = false;
            Snackbar.make(view, "Must Enter Category Name !", Snackbar.LENGTH_SHORT).show();

        }
        return status;
    }

    public void NoOfSubCategoryHave() {
        final DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = mFirebaseDatabaseReference.child("CategoryData").child(subCategoryListSpinner.getSelectedItem().toString()).orderByChild("subCategories");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Object value = child.getValue();
                    availableSubCategories = value.toString();
                    Log.e("Add Question details", "" + value);
                    noOfSubCategoryHave.setText("Number Of SubCategory :    " + value);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void AddSubCategoryButtonWork() {
        if (CheckAddCategoryControls()) {
            if (Utility.isOnline(getActivity())) {
                final DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
                CategoryValues categoryValues1 = new CategoryValues();
                categoryValues1.setSubCategoryName(addSubCategoryNameInput.getText().toString().trim());

                try {

                    int a = Integer.parseInt(availableSubCategories);
                    mFirebaseDatabaseReference.child("CategoryList").child(subCategoryListSpinner.getSelectedItem().toString())
                            .child("" +addSubCategoryNameInput.getText().toString().trim()).child("subCategoryName")
                            .setValue("" +addSubCategoryNameInput.getText().toString().trim());

                    mFirebaseDatabaseReference.child("CategoryData").child(subCategoryListSpinner.getSelectedItem().toString())
                            .child("subCategories").setValue(a+1);
                    Snackbar.make(view, "Category Created Successfully !", Snackbar.LENGTH_LONG).show();

                } catch (Exception e) {

                    Snackbar.make(view, "Network Problem !", Snackbar.LENGTH_LONG).show();
                    addSubCategoryButton.setEnabled(true);
                }


            } else {
                Snackbar.make(view, "No Internet Connection ", Snackbar.LENGTH_LONG).show();
            }
        }

    }
    public void SelectCategory() {
        final DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = mFirebaseDatabaseReference.child("CategoryList").orderByChild("categoryName");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                CategoryList.clear();
                CategoryList.add("Select Category");
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Object value = child.getValue();
                    CategoryList.add(((Map) value).get("categoryName").toString());
                    subCategoryListAdapter.notifyDataSetChanged();
                    Log.e("Add Question Details", value.toString());
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
