package com.omgupsapp.di;

import com.omgupsapp.data.remote.AuthApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_AuthApiFactory implements Factory<AuthApi> {
  @Override
  public AuthApi get() {
    return authApi();
  }

  public static AppModule_AuthApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AuthApi authApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.authApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_AuthApiFactory INSTANCE = new AppModule_AuthApiFactory();
  }
}
