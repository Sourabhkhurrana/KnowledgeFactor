package nougatstudio.knowledgefactor;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class PreparationFor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparation_for);
        Data.preparationNo = 0;
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PreparationforFragment pf = new PreparationforFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer_preparation_for, pf).commit();
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                if (getFragmentManager().getBackStackEntryCount() > 0)
//                    getFragmentManager().popBackStack();
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

