package com.example.justclean_mvvm_post;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.justclean_mvvm_post.databinding.CommentItemBindingImpl;
import com.example.justclean_mvvm_post.databinding.FragmentDetailBindingImpl;
import com.example.justclean_mvvm_post.databinding.FragmentFavouritesBindingImpl;
import com.example.justclean_mvvm_post.databinding.FragmentPostBindingImpl;
import com.example.justclean_mvvm_post.databinding.PostItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_COMMENTITEM = 1;

  private static final int LAYOUT_FRAGMENTDETAIL = 2;

  private static final int LAYOUT_FRAGMENTFAVOURITES = 3;

  private static final int LAYOUT_FRAGMENTPOST = 4;

  private static final int LAYOUT_POSTITEM = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.justclean_mvvm_post.R.layout.comment_item, LAYOUT_COMMENTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.justclean_mvvm_post.R.layout.fragment_detail, LAYOUT_FRAGMENTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.justclean_mvvm_post.R.layout.fragment_favourites, LAYOUT_FRAGMENTFAVOURITES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.justclean_mvvm_post.R.layout.fragment_post, LAYOUT_FRAGMENTPOST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.justclean_mvvm_post.R.layout.post_item, LAYOUT_POSTITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_COMMENTITEM: {
          if ("layout/comment_item_0".equals(tag)) {
            return new CommentItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for comment_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTDETAIL: {
          if ("layout/fragment_detail_0".equals(tag)) {
            return new FragmentDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFAVOURITES: {
          if ("layout/fragment_favourites_0".equals(tag)) {
            return new FragmentFavouritesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_favourites is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPOST: {
          if ("layout/fragment_post_0".equals(tag)) {
            return new FragmentPostBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_post is invalid. Received: " + tag);
        }
        case  LAYOUT_POSTITEM: {
          if ("layout/post_item_0".equals(tag)) {
            return new PostItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for post_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "comment");
      sKeys.put(2, "listener");
      sKeys.put(3, "post");
      sKeys.put(4, "viewmodel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/comment_item_0", com.example.justclean_mvvm_post.R.layout.comment_item);
      sKeys.put("layout/fragment_detail_0", com.example.justclean_mvvm_post.R.layout.fragment_detail);
      sKeys.put("layout/fragment_favourites_0", com.example.justclean_mvvm_post.R.layout.fragment_favourites);
      sKeys.put("layout/fragment_post_0", com.example.justclean_mvvm_post.R.layout.fragment_post);
      sKeys.put("layout/post_item_0", com.example.justclean_mvvm_post.R.layout.post_item);
    }
  }
}
