package com.example.nancyprojects.product;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class AddProduct extends AppCompatActivity {

    EditText editName, editCategory, editPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        final Button btnAdd;
        editName = (EditText) findViewById(R.id.editText_name);
        editCategory = (EditText) findViewById(R.id.editText_category);
        editPrice = (EditText) findViewById(R.id.editText_price);
        btnAdd = (Button) findViewById(R.id.button_addProduct);

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


            btnAdd.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            for (int i = 0; i < 11; i++) {

                                final Product sched = new Product();


                                /******* Firstly take data in model object ******/
                                sched.setName(editName.getText().toString());
                                sched.setCategory(editCategory.getText().toString());
                                sched.setPrice(Double.parseDouble(editPrice.getText().toString()));
                                sched.save();


                            }
                        }
                    }
            );
        }


}
