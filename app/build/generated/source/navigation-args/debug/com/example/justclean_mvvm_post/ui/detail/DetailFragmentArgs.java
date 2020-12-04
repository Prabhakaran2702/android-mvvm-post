package com.example.justclean_mvvm_post.ui.detail;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DetailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private DetailFragmentArgs() {
  }

  private DetailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static DetailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    DetailFragmentArgs __result = new DetailFragmentArgs();
    bundle.setClassLoader(DetailFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("postId")) {
      int postId;
      postId = bundle.getInt("postId");
      __result.arguments.put("postId", postId);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getPostId() {
    return (int) arguments.get("postId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("postId")) {
      int postId = (int) arguments.get("postId");
      __result.putInt("postId", postId);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    DetailFragmentArgs that = (DetailFragmentArgs) object;
    if (arguments.containsKey("postId") != that.arguments.containsKey("postId")) {
      return false;
    }
    if (getPostId() != that.getPostId()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getPostId();
    return result;
  }

  @Override
  public String toString() {
    return "DetailFragmentArgs{"
        + "postId=" + getPostId()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(DetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public DetailFragmentArgs build() {
      DetailFragmentArgs result = new DetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setPostId(int postId) {
      this.arguments.put("postId", postId);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getPostId() {
      return (int) arguments.get("postId");
    }
  }
}
