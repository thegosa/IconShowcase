package jahirfiquitiva.iconshowcase.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jahirfiquitiva.iconshowcase.activities.BaseActivity;
import jahirfiquitiva.iconshowcase.activities.ShowcaseActivity;

/**
 * Created by Allan Wang on 2016-08-19.
 *
 * Handles all fab related things
 */
public abstract class BaseFragment extends Fragment {

    public abstract void onFabClick(View v);

    abstract
    @DrawableRes
    int getFabIcon();

    abstract boolean hasFab();

    protected void showFab() {
        ((BaseActivity) getActivity()).getFab().show();
    }

    protected void hideFab() {
        ((BaseActivity) getActivity()).getFab().hide();
    }

    protected void setFabIcon(@DrawableRes int icon) {
        ((ShowcaseActivity) getActivity()).getFab().setImageResource(icon);
    }

    @CallSuper
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (hasFab()) {
            showFab();
            setFabIcon(getFabIcon());
        } else {
            hideFab();
        }
        return null;
    }

}
