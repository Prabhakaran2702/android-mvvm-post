package com.example.justclean_mvvm_post.databinding;
import com.example.justclean_mvvm_post.R;
import com.example.justclean_mvvm_post.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PostItemBindingImpl extends PostItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mListenerOnPostClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public PostItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private PostItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (androidx.cardview.widget.CardView) bindings[0]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.body.setTag(null);
        this.cardView.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.postid.setTag(null);
        this.title.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.post == variableId) {
            setPost((com.example.justclean_mvvm_post.data.model.Post) variable);
        }
        else if (BR.listener == variableId) {
            setListener((com.example.justclean_mvvm_post.ui.adapter.PostClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPost(@Nullable com.example.justclean_mvvm_post.data.model.Post Post) {
        this.mPost = Post;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.post);
        super.requestRebind();
    }
    public void setListener(@Nullable com.example.justclean_mvvm_post.ui.adapter.PostClickListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int postId = 0;
        java.lang.String stringValueOfPostId = null;
        android.view.View.OnClickListener listenerOnPostClickedAndroidViewViewOnClickListener = null;
        java.lang.String postTitle = null;
        java.lang.String postBody = null;
        com.example.justclean_mvvm_post.data.model.Post post = mPost;
        com.example.justclean_mvvm_post.ui.adapter.PostClickListener listener = mListener;

        if ((dirtyFlags & 0x5L) != 0) {



                if (post != null) {
                    // read post.id
                    postId = post.getId();
                    // read post.title
                    postTitle = post.getTitle();
                    // read post.body
                    postBody = post.getBody();
                }


                // read String.valueOf(post.id)
                stringValueOfPostId = java.lang.String.valueOf(postId);
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (listener != null) {
                    // read listener::onPostClicked
                    listenerOnPostClickedAndroidViewViewOnClickListener = (((mListenerOnPostClickedAndroidViewViewOnClickListener == null) ? (mListenerOnPostClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mListenerOnPostClickedAndroidViewViewOnClickListener).setValue(listener));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.body, postBody);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.postid, stringValueOfPostId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, postTitle);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(listenerOnPostClickedAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.example.justclean_mvvm_post.ui.adapter.PostClickListener value;
        public OnClickListenerImpl setValue(com.example.justclean_mvvm_post.ui.adapter.PostClickListener value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onPostClicked(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): post
        flag 1 (0x2L): listener
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}