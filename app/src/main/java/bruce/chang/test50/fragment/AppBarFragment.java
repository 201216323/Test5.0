package bruce.chang.test50.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bruce.chang.test50.R;
import bruce.chang.test50.RecyclerViewAdapter;

/**
 * Created by Administrator
 * Date:2016/11/28
 * Time:14:25
 * Author:BruceChang
 * Function:
 */

public class AppBarFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private String[] mtitles;


    public AppBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppBarFragment newInstance(String param1) {
        AppBarFragment fragment = new AppBarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            if (mParam1.equals("0")) {
                mtitles = new String[]{"1" + mParam1, "2" + mParam1, "3" + mParam1, "4" + mParam1, "5" + mParam1, "6" + mParam1, "7" + mParam1, "8" + mParam1, "9" + mParam1, "10" + mParam1};
            } else if (mParam1.equals("1")) {
                mtitles = new String[]{"1" + mParam1, "2" + mParam1, "3" + mParam1, "4" + mParam1, "5" + mParam1, "6" + mParam1, "7" + mParam1, "8" + mParam1, "9" + mParam1, "10" + mParam1};
            } else if (mParam1.equals("2")) {
                mtitles = new String[]{"1" + mParam1, "2" + mParam1, "3" + mParam1, "4" + mParam1, "5" + mParam1, "6" + mParam1, "7" + mParam1, "8" + mParam1, "9" + mParam1, "10" + mParam1};
            } else if (mParam1.equals("3")) {
                mtitles = new String[]{"1" + mParam1, "2" + mParam1, "3" + mParam1, "4" + mParam1, "5" + mParam1, "6" + mParam1, "7" + mParam1, "8" + mParam1, "9" + mParam1, "10" + mParam1};
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appbar, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter  = new RecyclerViewAdapter(getActivity(),mtitles);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
