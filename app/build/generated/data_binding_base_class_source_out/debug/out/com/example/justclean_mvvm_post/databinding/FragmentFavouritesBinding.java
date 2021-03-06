// Generated by data binding compiler. Do not edit!
package com.example.justclean_mvvm_post.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.justclean_mvvm_post.R;
import com.example.justclean_mvvm_post.ui.favourites.FavouritesViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentFavouritesBinding extends ViewDataBinding {
  @NonNull
  public final TextView listError;

  @NonNull
  public final ProgressBar loadingView;

  @NonNull
  public final RecyclerView postList;

  @NonNull
  public final SwipeRefreshLayout refreshLayout;

  @Bindable
  protected FavouritesViewModel mViewmodel;

  protected FragmentFavouritesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView listError, ProgressBar loadingView, RecyclerView postList,
      SwipeRefreshLayout refreshLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.listError = listError;
    this.loadingView = loadingView;
    this.postList = postList;
    this.refreshLayout = refreshLayout;
  }

  public abstract void setViewmodel(@Nullable FavouritesViewModel viewmodel);

  @Nullable
  public FavouritesViewModel getViewmodel() {
    return mViewmodel;
  }

  @NonNull
  public static FragmentFavouritesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_favourites, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentFavouritesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentFavouritesBinding>inflateInternal(inflater, R.layout.fragment_favourites, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentFavouritesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_favourites, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentFavouritesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentFavouritesBinding>inflateInternal(inflater, R.layout.fragment_favourites, null, false, component);
  }

  public static FragmentFavouritesBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentFavouritesBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentFavouritesBinding)bind(component, view, R.layout.fragment_favourites);
  }
}
