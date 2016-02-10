package com.example.nancyprojects.product;


import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.content.Context;
import android.util.Log;

/**
 * Created by Nancy on 02/10/2016.
 */
public class ListViewActivity extends BaseAdapter {
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater=null;
    public Resources res;
    Product tempValues=null;
    int i=0;

    public ListViewActivity(Activity a, ArrayList d){

        /********** Take passed values **********/
        activity = a;
        data=d;


        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    AddProduct prAdd=new AddProduct();
    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;


        if(convertView==null){

            /****** Inflate content_add_product.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.content_add_product, null);

            /****** AddProduct Object to content_add_product.xml file elements ******/
            /************  Set holder with LayoutInflater ************/


            vi.setTag( prAdd );
        }
        else
            prAdd=(AddProduct)vi.getTag();

        if(data.size()<=0)
        {
            prAdd.editName.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            tempValues=null;
            tempValues = ( Product ) data.get( position );

            /************  Set Model values in Holder elements ***********/

            prAdd.editName.setText( tempValues.getName() );
            prAdd.editCategory.setText( tempValues.getCategory() );
            prAdd.editPrice.setText(String.valueOf(tempValues.getPrice()));

            /******** Set Item Click Listner for LayoutInflater for each row *******/

            vi.setOnClickListener(new View.OnClickListener() {


                                      @Override
                                      public void onClick(View v) {
                                          Log.v("CustomAdapter", "=====Row button clicked=====");
                                      }
                                  }
            );
        }
        return vi;
    }



    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements View.OnClickListener{
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View arg0) {


            MainActivity sct = (MainActivity)activity;

            /****  Call  onItemClick Method inside MainActivity Class ( See Below )****/

            sct.onItemClick(mPosition);
        }
    }
}


