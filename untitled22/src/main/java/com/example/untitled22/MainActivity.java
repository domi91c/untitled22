package com.example.untitled22;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends ActionBarActivity {


    private LinearLayout parentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.drink_form_fragment, new DrinkFormFragment())
                    .commit();
        }

        parentLayout = (LinearLayout) findViewById(R.id.mainParent);

        inflateAddButton();



    }



    /**
     * Drink form fragment containing form for single drink.
     */
    public static class DrinkFormFragment extends Fragment {

        public DrinkFormFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }


    private void inflateAddButton() {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.add_form_layout, null);

        Button addForm = (Button) findViewById(R.id.bAddForm);


        addForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parentLayout.addView(rowView);
            }
        });
    }



    }
