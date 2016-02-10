package com.example.nancyprojects.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView list;
    ListViewActivity adapter;
    public MainActivity CustomListView = null;
    public ArrayList<Product> CustomListViewValuesArr = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.button_add);

        CustomListView = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();


        list= ( ListView )findViewById( R.id.listView );  // List defined in XML ( See Below )

        /**************** Create Custom Adapter *********/
        adapter=new ListViewActivity( CustomListView, CustomListViewValuesArr);
        list.setAdapter( adapter );
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(MainActivity.this,AddProduct.class));


                    }
                }
        );




    }
    /****** Function to set data in ArrayList *************/
    public void setListData()
    {


        for (int i = 0; i < 11; i++) {

            final Product sched = new Product();
            final AddProduct add = new AddProduct();

            /******* Firstly take data in model object ******/
            sched.setName(add.editName.getText().toString());
            sched.setCategory(add.editCategory.getText().toString());
            sched.setPrice(Double.parseDouble(add.editPrice.getText().toString()));
            sched.save();

            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add( sched );
        }


    }
    /*****************  This function used by adapter ****************/
    public void onItemClick (int mPosition) {
      final Product tempValues = ( Product ) CustomListViewValuesArr.get(mPosition);
        AddProduct ad = new AddProduct();


    Toast.makeText(CustomListView,
            "" + tempValues.getName()
                    + "Category:"+tempValues.getCategory()
            +"Price:"+tempValues.getPrice(),
    Toast.LENGTH_LONG)
    .show();



}




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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}