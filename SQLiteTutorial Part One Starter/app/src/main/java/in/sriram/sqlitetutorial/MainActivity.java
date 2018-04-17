package in.sriram.sqlitetutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.sriram.sqlitetutorial.model.BakerItem;

public class MainActivity extends AppCompatActivity implements BakerItemAdapter.BakerItemListener {

    @BindView(R.id.rv_baker_items)
    RecyclerView mBakerRv;
    @BindView(R.id.fab_add_notes)
    FloatingActionButton fabAddNotes;

    private BakerItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBakerRv = findViewById(R.id.rv_baker_items);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new BakerItemAdapter(this, this);

        mBakerRv.setLayoutManager(layoutManager);
        mBakerRv.setAdapter(mAdapter);

        getDataFromDatabase();

    }

    private void getDataFromDatabase() {
        List<BakerItem> items = new ArrayList<>();

        // TODO get data from adapter and fill it in

        setItemsToAdapter(items);
    }

    @OnClick(R.id.fab_add_notes)
    public void onFabClicked() {
        Intent i = new Intent(this, ItemsDetailActivity.class);
        i.putExtra(Constants.ACTIVITY_TAG, Constants.ITEM_ADD_NEW);
        startActivity(i);
    }

    private void setItemsToAdapter(List<BakerItem> items) {
        mAdapter.addItems(items);
    }

    @Override
    public void onItemClicked(BakerItem item) {
        Intent i = new Intent(this, ItemsDetailActivity.class);
        i.putExtra(Constants.ACTIVITY_TAG, Constants.ITEM_UPDATE);
        i.putExtra(Constants.ID_OF_ITEM, item.getId());
        startActivity(i);
    }
}
