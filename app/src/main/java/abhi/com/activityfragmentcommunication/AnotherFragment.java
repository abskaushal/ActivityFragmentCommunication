package abhi.com.activityfragmentcommunication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class AnotherFragment extends Fragment implements IFragment {


    private IActivityCallback callback;
    private TextView tv;

    public AnotherFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_another, container, false);

        tv = (TextView) view.findViewById(R.id.data);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        callback = (IActivityCallback)context;
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        if(callback!=null){
            callback.onFragmentAttach(this);
        }

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void setData(String data) {
        Log.v("Hello--",""+data);
        tv.setText(data);
    }
}
