package com.example.justclean_mvvm_post.ui.post;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.justclean_mvvm_post.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PostFragmentDirections {
  private PostFragmentDirections() {
  }

  @NonNull
  public static ActionNavigationPostToScrollingFragment actionNavigationPostToScrollingFragment() {
    return new ActionNavigationPostToScrollingFragment();
  }

  public static class ActionNavigationPostToScrollingFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionNavigationPostToScrollingFragment() {
    }

    @NonNull
    public ActionNavigationPostToScrollingFragment setPostId(int postId) {
      this.arguments.put("postId", postId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("postId")) {
        int postId = (int) arguments.get("postId");
        __result.putInt("postId", postId);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_navigation_post_to_scrollingFragment;
    }

    @SuppressWarnings("unchecked")
    public int getPostId() {
      return (int) arguments.get("postId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionNavigationPostToScrollingFragment that = (ActionNavigationPostToScrollingFragment) object;
      if (arguments.containsKey("postId") != that.arguments.containsKey("postId")) {
        return false;
      }
      if (getPostId() != that.getPostId()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getPostId();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionNavigationPostToScrollingFragment(actionId=" + getActionId() + "){"
          + "postId=" + getPostId()
          + "}";
    }
  }
}
