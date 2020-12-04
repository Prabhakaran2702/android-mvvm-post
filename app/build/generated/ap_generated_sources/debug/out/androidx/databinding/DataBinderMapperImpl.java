package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.example.justclean_mvvm_post.DataBinderMapperImpl());
  }
}
