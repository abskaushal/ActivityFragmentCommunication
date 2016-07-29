package abhi.com.activityfragmentcommunication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements IActivityCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.container, new MainActivityFragment()).commit();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        if (id == R.id.action_first) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainActivityFragment()).commit();
            return true;
        }

        if (id == R.id.action_another) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container, new AnotherFragment()).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called by the Fragment when it is attached
     * @param fragment
     */
    @Override
    public void onFragmentAttach(IFragment fragment) {

        if(fragment instanceof MainActivityFragment) {
            fragment.setData("Main Fragment Data");
        }else if(fragment instanceof AnotherFragment){
            fragment.setData("Another Fragment Data");
        }
    }
}
