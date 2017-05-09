package group3.tcss450.uw.edu.multifragmentui;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SearchBarFragment.OnFragmentInteractionListener,
        ContentFragment.OnFragmentInteractionListener {
    private ContentFragment mContentFragment;
    private SearchBarFragment mSearchBarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentFragment = (ContentFragment) getSupportFragmentManager()
                .findFragmentById(R.id.content_fragment);
        mSearchBarFragment = (SearchBarFragment) getSupportFragmentManager()
                .findFragmentById(R.id.search_fragment);
    }

    @Override
    public void onFragmentInteraction(String theText) {
        mContentFragment.updateTextContent(theText);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_fragment, new ReplacementFragment())
                .commit();
    }
}
