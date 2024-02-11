package com.omgupsapp.di;

import com.omgupsapp.data.DataStoreManager;
import com.omgupsapp.data.remote.AuthApi;
import com.omgupsapp.domain.repository.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<AuthApi> apiProvider;

  private final Provider<DataStoreManager> dataStoreManagerProvider;

  public AppModule_ProvideAuthRepositoryFactory(Provider<AuthApi> apiProvider,
      Provider<DataStoreManager> dataStoreManagerProvider) {
    this.apiProvider = apiProvider;
    this.dataStoreManagerProvider = dataStoreManagerProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(apiProvider.get(), dataStoreManagerProvider.get());
  }

  public static AppModule_ProvideAuthRepositoryFactory create(Provider<AuthApi> apiProvider,
      Provider<DataStoreManager> dataStoreManagerProvider) {
    return new AppModule_ProvideAuthRepositoryFactory(apiProvider, dataStoreManagerProvider);
  }

  public static AuthRepository provideAuthRepository(AuthApi api,
      DataStoreManager dataStoreManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthRepository(api, dataStoreManager));
  }
}
