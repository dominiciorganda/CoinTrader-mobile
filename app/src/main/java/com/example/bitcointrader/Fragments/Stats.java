package com.example.bitcointrader.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bitcointrader.Entities.Coin;
import com.example.bitcointrader.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Stats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Stats extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String MAX = "maxCoin";
    private static final String ACTUAL = "actualCoin";
    private static final String ANUALMAX = "anualMax";
    private static final String ANUALMIN = "anualMin";


    // TODO: Rename and change types of parameters
    private Coin maxCoin, anualMax, anualMin, actualCoin;

    public Stats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Stats.
     */
    // TODO: Rename and change types and number of parameters
    public static Stats newInstance(Coin maxCoin, Coin anualMax, Coin anualMin, Coin actualCoin) {
        Stats fragment = new Stats();
        Bundle args = new Bundle();
        args.putParcelable(MAX, maxCoin);
        args.putParcelable(ANUALMAX, anualMax);
        args.putParcelable(ANUALMIN, anualMin);
        args.putParcelable(ACTUAL, actualCoin);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        if (getArguments() != null) {
            maxCoin = getArguments().getParcelable("MAX");
            anualMax = getArguments().getParcelable("ANUALMAX");
            anualMin = getArguments().getParcelable("ANUALMIN");
            actualCoin = getArguments().getParcelable("ACTUAL");
        } else
            System.out.println("ok");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (maxCoin != null && anualMax != null && anualMin != null && actualCoin != null) {
            fillStats();
        } else
            System.out.println("Error");

    }

    public void fillStats() {
        TextView maxPrice = (TextView) getView().findViewById(R.id.maxPrice);
        maxPrice.setText(maxCoin.showPrice());

        TextView anualMaxPrice = (TextView) getView().findViewById(R.id.anualMax);
        anualMaxPrice.setText(anualMax.showPrice());

        TextView anualMinPrice = (TextView) getView().findViewById(R.id.anualMin);
        anualMinPrice.setText(anualMin.showPrice());

        TextView actualPrice = (TextView) getView().findViewById(R.id.actualPrice);
        actualPrice.setText(actualCoin.showPrice());
    }


}