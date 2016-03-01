package com.example.nancyprojects.product.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;
import com.example.nancyprojects.product.R;
import com.example.nancyprojects.product.adapter.BaseListAdapter;
import com.example.nancyprojects.product.adapter.ProductListAdapter;
import com.example.nancyprojects.product.models.Product;
import java.util.List;
import static com.example.nancyprojects.product.activity.AddProductActivity.KEY_NAME;
import static com.example.nancyprojects.product.activity.AddProductActivity.KEY_CATEGORY;
import static com.example.nancyprojects.product.activity.AddProductActivity.KEY_PRICE;


public class MainActivity extends AppCompatActivity {


   private List<Product> repayments = Product.listAll(Product.class);

    private ProductListAdapter adapter;

   // BaseListAdapter<Product> CustomListViewValuesArr ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getResources().getString(R.string.product_detail_activity_title));

        final ListView   list = (ListView) findViewById(R.id.listView);
        adapter = new ProductListAdapter(getApplicationContext(),repayments);
        if(repayments.size()>0) {

            list.setAdapter(adapter);
        }
        loadData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(view.getContext(), AddProductActivity.class);
                startActivity(in);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object obj = list.getItemAtPosition(position);
                // final AddProductActivity ad = new AddProductActivity();
                Product tempValues = (Product) obj;


                Toast.makeText(getApplicationContext(),
                        "Name" + tempValues.getName()
                                + "Category:" + tempValues.getCategory()
                                + "Price:" + tempValues.getPrice(),
                        Toast.LENGTH_LONG)
                        .show();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }



    void loadData( ) {


        Bundle extras = getIntent().getExtras();

        String Name="";
        String Category="";
        Integer Price;

        if (null != extras) {

            /**************** Create Custom Adapter *********/
            Name = extras.getString(KEY_NAME);
            Category = extras.getString(KEY_CATEGORY);
            Price = extras.getInt(KEY_PRICE);
            Product tempValues = new Product(Name,Category,Price);
            repayments.add(tempValues);

            adapter.notifyDataSetChanged();
        }

}






    /*****************  This function used by adapter ****************/



    /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> a, View v, int position, long id) {

            final Product tempValues = CustomListViewValuesArr.getItem(position);
            Toast.makeText(getApplicationContext(),
                    "Name" + tempValues.getName()
                            + "Category:" + tempValues.getCategory()
                            + "Price:" + tempValues.getPrice(), Toast.LENGTH_LONG)
                    .show();
        }
    });*/
  /* public void onItemClick (AdapterView<?> a, View v, int position, long id) {
      final Product tempValues = CustomListViewValuesArr.getItem(position);
      // final AddProductActivity ad = new AddProductActivity();


    Toast.makeText(getApplicationContext(),
            "Name" + tempValues.getName()
                    + "Category:" + tempValues.getCategory()
                    + "Price:" + tempValues.getPrice(),
            Toast.LENGTH_LONG)
    .show();
}*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

     /* switch (id){
          case R.id.action_delete:
              if (app.product.getId() != null) {
                  app.product.delete();
              }
              finish();
              break;
          case R.id.action_edit:
              app.editMode = true;
              Intent edit_intent = new Intent(this, AddProductActivity.class);
              startActivity(edit_intent);
              break;

          case android.R.id.home:
              Intent intent = new Intent(this, MainActivity.class);
              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(intent);
              return true;

      }*/



        return super.onOptionsItemSelected(item);

    }

}

