package com.omgupsapp.di;

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
public final class AppModule_ProvideMyCookieJarFactory implements Factory<MyCookieJar> {
  @Override
  public MyCookieJar get() {
    return provideMyCookieJar();
  }

  public static AppModule_ProvideMyCookieJarFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MyCookieJar provideMyCookieJar() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMyCookieJar());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideMyCookieJarFactory INSTANCE = new AppModule_ProvideMyCookieJarFactory();
  }
}
