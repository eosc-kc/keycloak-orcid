package org.keycloak.social.orcid;

import org.keycloak.broker.provider.AbstractIdentityProviderFactory;
import org.keycloak.broker.social.SocialIdentityProviderFactory;
import org.keycloak.models.IdentityProviderModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;

import java.util.List;

public class OrcidIdentityProviderFactory extends AbstractIdentityProviderFactory<OrcidIdentityProvider> implements SocialIdentityProviderFactory<OrcidIdentityProvider> {

    public static final String PROVIDER_ID = "orcid";

    @Override
    public String getName() {
        return "ORCID";
    }

    @Override
    public OrcidIdentityProvider create(KeycloakSession session, IdentityProviderModel model) {
        return new OrcidIdentityProvider(session, new OrcidIdentityProviderConfig(model));
    }

    @Override
    public OrcidIdentityProviderConfig createConfig() {
        return new OrcidIdentityProviderConfig();
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return ProviderConfigurationBuilder.create()
                .property().name("baseUrl")
                .label("Base Url")
                .helpText("Base Url to ORCID Online API. Default to https://orcid.org/oauth.")
                .type(ProviderConfigProperty.STRING_TYPE).add()
                .property().name("userInfoUrl")
                .label("User info")
                .helpText("The User Info Url.Default to https://pub.orcid.org/v3.0.")
                .type(ProviderConfigProperty.STRING_TYPE).add().build();
    }
}