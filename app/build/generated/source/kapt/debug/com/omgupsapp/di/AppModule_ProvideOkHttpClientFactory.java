package com.omgupsapp.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class AppModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<MyCookieJar> cookieJarProvider;

  public AppModule_ProvideOkHttpClientFactory(Provider<MyCookieJar> cookieJarProvider) {
    this.cookieJarProvider = cookieJarProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(cookieJarProvider.get());
  }

  public static AppModule_ProvideOkHttpClientFactory create(
      Provider<MyCookieJar> cookieJarProvider) {
    return new AppModule_ProvideOkHttpClientFactory(cookieJarProvider);
  }

  public static OkHttpClient provideOkHttpClient(MyCookieJar cookieJar) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideOkHttpClient(cookieJar));
  }
}
