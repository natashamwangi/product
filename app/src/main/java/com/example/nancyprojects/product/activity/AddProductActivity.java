package com.example.nancyprojects.product.activity;

import android.app.AlertDialog;
import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;
import com.example.nancyprojects.product.R;
import com.example.nancyprojects.product.models.Product;
import com.example.nancyprojects.product.ProductApp;


public class AddProductActivity extends AppCompatActivity {
    Button btnAdd;
    Product sched;
    private ProductApp app;
    private EditText editName, editCategory, editPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


        editName = (EditText) findViewById(R.id.editText_name);
        editCategory = (EditText) findViewById(R.id.editText_category);
        editPrice = (EditText) findViewById(R.id.editText_price);
        btnAdd = (Button) findViewById(R.id.button_addProduct);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        app = (ProductApp) getApplication();

        setTitle(getResources().getString(R.string.title_activity_add_product));

        if (app.editMode) {
            sched = app.product;

            editName.setText(sched.getName());
            editCategory.setText(sched.getCategory());
            editPrice.setText(String.valueOf(sched.getPrice()));
        }
        else {
            sched = new Product(getApplicationContext());
        }


        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Log.d("Add Product","I am here...");
                        String ediName=((EditText) findViewById(R.id.editText_name)).getText().toString();
                        String ediCategory=((EditText) findViewById(R.id.editText_category)).getText().toString();
                        String ediPrice= ((EditText) findViewById(R.id.editText_price)).getText().toString();


                        if (ediPrice.trim().equals("") ||ediName.trim().equals("")||ediCategory.trim().equals("")) {
                            Toast.makeText(getApplicationContext(), "Empty fields",
                                    Toast.LENGTH_LONG).show();
                        }
                        else {
                            boolean b = true;
                            try {
                                sched.setPrice(Double.parseDouble(ediPrice));
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "Wrong input",
                                        Toast.LENGTH_LONG).show();
                                b= false;
                            }

                            if(b)
                            {
                                sched.save();
                                AlertDialog builder = new AlertDialog.Builder(AddProductActivity.this).create();
                                builder.setTitle("Product Saved");
                                builder.setMessage("Success.Product saved successfully");
                                builder.show();
                            }
                            // doNotify();
                          /*  try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                            if(b){
                                finish();
                            }
                        }

                        finish();
                    }
                }
        );





       /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){


            case R.id.action_save:
                String ediName=((EditText) findViewById(R.id.editText_name)).getText().toString();
                String ediCategory=((EditText) findViewById(R.id.editText_category)).getText().toString();
                String ediPrice= ((EditText) findViewById(R.id.editText_price)).getText().toString();


                if (ediPrice.trim().equals("") ||ediName.trim().equals("")||ediCategory.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Empty fields",
                            Toast.LENGTH_LONG).show();
                } else {
                    boolean b = true;
                    try {
                        sched.setPrice(Double.parseDouble(ediPrice));
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Wrong input",
                                Toast.LENGTH_LONG).show();
                        b= false;
                    }

                    if(b)
                    {
                        sched.save();
                        AlertDialog builder = new AlertDialog.Builder(this).create();
                        builder.setTitle("Product Saved");
                        builder.setMessage("Success.Product saved successfully");
                        builder.show();
                    }
                    // doNotify();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(b){
                        finish();
                    }
                }
                break;
            case R.id.action_delete:
                if (sched.getId() != null) {
                    sched.delete();
                }
                finish();
                break;


            case android.R.id.home:
                if (app.editMode) {
                    app.editMode = false;
                    finish();
                } else {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

        }

        return super.onOptionsItemSelected(item);
    }





}




