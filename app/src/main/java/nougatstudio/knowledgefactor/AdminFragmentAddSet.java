package nougatstudio.knowledgefactor;


import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragmentAddSet extends Fragment implements View.OnClickListener {

    View root;
    Spinner SetSelection, AnswersSpiner, selectCategorySpinner, SubCategorySpinner;

    TextView noOfQuestionHave;
    EditText option1, option2, option3, option4, question, explanation;
    // Buttons
    Button addQuestionButton, resetButton;
    int availableSets = 0, availableQuestions = 0;


    //Spinner Adapter
    ArrayAdapter<String> CategoryListAdapter, subCategoryListAdapter, SetSelectionAdapter;

    //List
    List<String> CategoryList = new ArrayList<String>();
    List<String> SubCategoryList = new ArrayList<String>();
    List<String> CategoryModeValues = new ArrayList<String>();

    public AdminFragmentAddSet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_admin_fragment_add_set, container, false);

        resetButton = (Button) root.findViewById(R.id.addQuestionResetBUtton);
        addQuestionButton = (Button) root.findViewById(R.id.addQuestionButton);
        resetButton.setOnClickListener(this);
        addQuestionButton.setOnClickListener(this);

        //EditText
        option1 = (EditText) root.findViewById(R.id.option1);
        option2 = (EditText) root.findViewById(R.id.option2);
        option3 = (EditText) root.findViewById(R.id.option3);
        option4 = (EditText) root.findViewById(R.id.option4);
        question = (EditText) root.findViewById(R.id.question);
        explanation = (EditText) root.findViewById(R.id.explanation);

        //TextView
        noOfQuestionHave = (TextView) root.findViewById(R.id.noOfQuestionHave);
        selectCategorySpinner = (Spinner) root.findViewById(R.id.selectCategorySpinner);
        SubCategorySpinner = (Spinner) root.findViewById(R.id.SubCategorySpinner);
        AnswersSpiner = (Spinner) root.findViewById(R.id.answerOptionSpinner);
        //SetSelection = (Spinner) root.findViewById(R.id.SetSelection);

        selectCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position > 0) {

                    ForSubCategory();
                    SelectSubCategory();
                } else {
                    noOfQuestionHave.setText("Number Of Questions :    ");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ForCategory();
        SelectCategory();
        return root;
    }

    @Override
    public void onClick(View view) {

    }

    public void ForCategory() {
        CategoryList.clear();
        CategoryList.add("Select Category");
        CategoryListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, CategoryList);
        CategoryListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectCategorySpinner.setAdapter(CategoryListAdapter);

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
                    CategoryListAdapter.notifyDataSetChanged();
                    Log.e("Add Question Details", value.toString());
                    //SelectSubCategory();
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void ForSubCategory() {
        SubCategoryList.clear();
        SubCategoryList.add("Select SubCategory");
        subCategoryListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, SubCategoryList);
        subCategoryListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SubCategorySpinner.setAdapter(subCategoryListAdapter);

    }

    public void SelectSubCategory() {

        SubCategoryList.clear();
        SubCategoryList.add("Select SubCategory");
        final DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        Query query = mFirebaseDatabaseReference.child("CategoryList").child("" + selectCategorySpinner.getSelectedItem().toString())
                .child("subCategoryName");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Object value = child.getValue();
                    Toast.makeText(getActivity(), ""+ ((Map) value).get("subCategoryName").toString(), Toast.LENGTH_SHORT).show();
                    SubCategoryList.add("" + ((Map) value).get("subCategoryName").toString());
                    Log.e("Add Question Details", value.toString());
                    subCategoryListAdapter.notifyDataSetChanged();

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
