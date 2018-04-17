package in.sriram.sqlitetutorial;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.sriram.sqlitetutorial.model.BakerItem;
import in.sriram.sqlitetutorial.sqlite.BakerItemContract;
import in.sriram.sqlitetutorial.sqlite.BakerItemOpenHelper;

public class ItemsDetailActivity extends AppCompatActivity {

    @BindView(R.id.edt_title)
    TextInputEditText edtTitle;
    @BindView(R.id.layout_title)
    TextInputLayout layoutTitle;
    @BindView(R.id.edt_cost)
    TextInputEditText edtCost;
    @BindView(R.id.layout_cost)
    TextInputLayout layoutCost;
    @BindView(R.id.edt_time)
    TextInputEditText edtTime;
    @BindView(R.id.layout_time)
    TextInputLayout layoutTime;
    @BindView(R.id.btn_save_data)
    Button btnSaveData;

    private String tag = Constants.ITEM_ADD_NEW;

    private static final String TAG = ItemsDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_detail);
        ButterKnife.bind(this);

        Intent i = getIntent();
        if (i == null || i.hasExtra(Constants.ACTIVITY_TAG)) {
            Toast.makeText(this, "Error opening activity", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "Intent is null or intent does not contain the extras");
            return;
        }

        tag = i.getStringExtra(Constants.ACTIVITY_TAG);

        if (tag.equals(Constants.ITEM_ADD_NEW)) {
            btnSaveData.setText("Add Item");
        } else {
            btnSaveData.setText("Update Item");
            int id = i.getIntExtra(Constants.ID_OF_ITEM, 0);
            getItemFromDatabase(id);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        
    }

    private void getItemFromDatabase(int id) {

        String title, time, cost;

        // TODO get data from database and update

        edtTitle.setText(title);
        edtTime.setText(time);
        edtCost.setText(cost);
    }

    @OnClick(R.id.btn_save_data)
    public void onSaveData() {

        String title = edtTitle.getText().toString().trim();
        String time = edtTime.getText().toString().trim();
        String cost = edtCost.getText().toString().trim();

        BakerItem item = new BakerItem(title, cost, time);

        if (tag.equals(Constants.ITEM_UPDATE)) {
            updateItem(item);
        } else {
            addNewItem(item);
        }

    }


    private void addNewItem(BakerItem item) {

    }

    private void updateItem(BakerItem item) {
        int id = getIntent().getIntExtra(Constants.ID_OF_ITEM, 0);
    }
}
