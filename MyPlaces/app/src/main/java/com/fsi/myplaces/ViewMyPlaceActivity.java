package com.fsi.myplaces;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class ViewMyPlaceActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_place);

        int position = -1;
        try
        {
            Intent listIntent = getIntent();
            Bundle positionBundle = listIntent.getExtras();
            position = positionBundle.getInt("position");
        }
        catch(Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            finish();
        }

        if (position >= 0)
        {
            MyPlace place = MyPlacesData.getInstance().getPlace(position);
            TextView tvName = (TextView)findViewById(R.id.view_my_place_name_text);
            tvName.setText(place.getName());

            TextView tvDesc = (TextView)findViewById(R.id.view_my_place_desc_text);
            tvDesc.setText(place.getDescription());
        }

        final Button finishedButton = (Button)findViewById(R.id.view_my_place_finished_button);
        finishedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_my_place, menu);
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
}
