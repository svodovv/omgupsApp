package com.omgupsapp.data.repository;

import com.omgupsapp.data.DataStoreManager;
import com.omgupsapp.data.remote.AuthApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AuthRepositoryImpl_Factory implements Factory<AuthRepositoryImpl> {
  private final Provider<AuthApi> apiProvider;

  private final Provider<DataStoreManager> dataStoreManagerProvider;

  public AuthRepositoryImpl_Factory(Provider<AuthApi> apiProvider,
      Provider<DataStoreManager> dataStoreManagerProvider) {
    this.apiProvider = apiProvider;
    this.dataStoreManagerProvider = dataStoreManagerProvider;
  }

  @Override
  public AuthRepositoryImpl get() {
    return newInstance(apiProvider.get(), dataStoreManagerProvider.get());
  }

  public static AuthRepositoryImpl_Factory create(Provider<AuthApi> apiProvider,
      Provider<DataStoreManager> dataStoreManagerProvider) {
    return new AuthRepositoryImpl_Factory(apiProvider, dataStoreManagerProvider);
  }

  public static AuthRepositoryImpl newInstance(AuthApi api, DataStoreManager dataStoreManager) {
    return new AuthRepositoryImpl(api, dataStoreManager);
  }
}
