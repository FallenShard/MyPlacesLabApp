package com.fsi.myplaces;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditMyPlaceActivity extends ActionBarActivity implements View.OnClickListener {

    private boolean editMode = true;
    private int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_place);

        try
        {
            Intent listIntent = getIntent();
            Bundle positionBundle = listIntent.getExtras();
            if (positionBundle != null)
            {
                position = positionBundle.getInt("position");
            }
            else
            {
                editMode = false;
            }
        }
        catch (Exception ex)
        {
            editMode = false;
        }

        final Button okButton = (Button)findViewById(R.id.edit_my_place_finished_button);
        okButton.setOnClickListener(this);
        okButton.setEnabled(false);
        okButton.setText("Add");

        final Button cancelButton = (Button)findViewById(R.id.edit_my_place_cancel_button);
        cancelButton.setOnClickListener(this);

        final EditText nameEditText = (EditText)findViewById(R.id.edit_my_place_name_edit);
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                okButton.setEnabled(s.length() > 0);
            }
        });

        if (!editMode)
        {
            okButton.setEnabled(false);
            okButton.setText("Add");
        }
        else if (position >= 0)
        {
            okButton.setText("Save");

            MyPlace place = MyPlacesData.getInstance().getPlace(position);
            nameEditText.setText(place.getName());

            final EditText descEditText = (EditText)findViewById(R.id.edit_my_place_desc_edit);
            descEditText.setText(place.getDescription());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_my_place, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.show_map_item:
            {
                Toast.makeText(this, "Show Map!", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.my_places_list_item:
            {
                Intent intent = new Intent(this, MyPlacesListActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.about_item:
            {
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.edit_my_place_finished_button:
            {
                EditText etName = (EditText)findViewById(R.id.edit_my_place_name_edit);
                String name = etName.getText().toString();

                EditText etDesc = (EditText)findViewById(R.id.edit_my_place_desc_edit);
                String desc = etDesc.getText().toString();

                if (!editMode)
                {
                    MyPlace place = new MyPlace(name, desc);
                    MyPlacesData.getInstance().addNewPlace(place);
                } else {
                    MyPlace place = MyPlacesData.getInstance().getPlace(position);
                    place.setName(name);
                    place.setDescription(desc);
                }

                setResult(Activity.RESULT_OK);
                finish();
                break;
            }

            case R.id.edit_my_place_cancel_button:
            {
                setResult(Activity.RESULT_CANCELED);
                finish();
                break;
            }
        }
    }
}
