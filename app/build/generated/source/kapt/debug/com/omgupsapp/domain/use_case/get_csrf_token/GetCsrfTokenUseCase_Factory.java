package com.omgupsapp.domain.use_case.get_csrf_token;

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
public final class GetCsrfTokenUseCase_Factory implements Factory<GetCsrfTokenUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public GetCsrfTokenUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetCsrfTokenUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetCsrfTokenUseCase_Factory create(Provider<AuthRepository> repositoryProvider) {
    return new GetCsrfTokenUseCase_Factory(repositoryProvider);
  }

  public static GetCsrfTokenUseCase newInstance(AuthRepository repository) {
    return new GetCsrfTokenUseCase(repository);
  }
}
