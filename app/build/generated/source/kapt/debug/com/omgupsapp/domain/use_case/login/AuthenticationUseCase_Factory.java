package com.omgupsapp.domain.use_case.login;

import com.omgupsapp.domain.repository.AuthRepository;
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
public final class AuthenticationUseCase_Factory implements Factory<AuthenticationUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public AuthenticationUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public AuthenticationUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static AuthenticationUseCase_Factory create(Provider<AuthRepository> repositoryProvider) {
    return new AuthenticationUseCase_Factory(repositoryProvider);
  }

  public static AuthenticationUseCase newInstance(AuthRepository repository) {
    return new AuthenticationUseCase(repository);
  }
}
