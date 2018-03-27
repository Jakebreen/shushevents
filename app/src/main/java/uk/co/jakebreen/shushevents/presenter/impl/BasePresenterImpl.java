package uk.co.jakebreen.shushevents.presenter.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import uk.co.jakebreen.shushevents.presenter.BasePresenter;

/**
 * Abstract presenter implementation that contains base implementation for other presenters.
 * Subclasses must call super for all {@link BasePresenter} method overriding.
 */
public abstract class BasePresenterImpl<V> implements BasePresenter<V> {

    protected FirebaseUser user;

    /**
     * The view
     */
    @Nullable
    protected V mView;

    @Override
    public void onViewAttached(@NonNull V view) {
        mView = view;
    }


    @Override
    public void onStart(boolean viewCreated) {

    }

    @Override
    public void onStop() {

    }


    @Override
    public void onViewDetached() {
        mView = null;
    }

    @Override
    public void onPresenterDestroyed() {

    }

    @Override
    public boolean checkLoggedOn() {
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            return true;
        }
        return false;
    }


}
