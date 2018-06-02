package com.usuario.pedroultimoentregable.View;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.usuario.pedroultimoentregable.Model.Cuadro;


/**
 * Created by DH on 1/6/2018.
 */

public class AdapterViewPager extends FragmentStatePagerAdapter {



    private List<Fragment> listaCuadrosFragment;

    public AdapterViewPager(FragmentManager fm, List<Cuadro> cuadros) {
        super(fm);
        listaCuadrosFragment = new ArrayList<>();

        for (Cuadro cuadro : cuadros) {
            FragmentDetalle fragmentDetalle = FragmentDetalle.fabricaFragmentCuadros(cuadro);
            listaCuadrosFragment.add(fragmentDetalle);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return listaCuadrosFragment.get(position);
    }

    @Override
    public int getCount() {
        return listaCuadrosFragment.size();
    }

}
