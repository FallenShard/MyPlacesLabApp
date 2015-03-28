package com.fsi.myplaces;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.show_map_item:
            {
                Toast.makeText(this, "Show Map!", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.new_place_item:
            {
                Toast.makeText(this, "New Place!", Toast.LENGTH_SHORT).show();
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
