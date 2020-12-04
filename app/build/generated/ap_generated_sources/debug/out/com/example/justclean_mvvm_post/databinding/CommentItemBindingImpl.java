package com.example.justclean_mvvm_post.databinding;
import com.example.justclean_mvvm_post.R;
import com.example.justclean_mvvm_post.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CommentItemBindingImpl extends CommentItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 4);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CommentItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private CommentItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[1]
            );
        this.body.setTag(null);
        this.email.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.name.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.comment == variableId) {
            setComment((com.example.justclean_mvvm_post.data.model.Comment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setComment(@Nullable com.example.justclean_mvvm_post.data.model.Comment Comment) {
        this.mComment = Comment;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.comment);
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
        com.example.justclean_mvvm_post.data.model.Comment comment = mComment;
        java.lang.String commentName = null;
        java.lang.String commentEmail = null;
        java.lang.String commentBody = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (comment != null) {
                    // read comment.name
                    commentName = comment.getName();
                    // read comment.email
                    commentEmail = comment.getEmail();
                    // read comment.body
                    commentBody = comment.getBody();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.body, commentBody);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.email, commentEmail);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, commentName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): comment
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}