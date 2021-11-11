# keycloak-orcid

**UNDER CONSTRUCTION**

- [keycloak-orcid](#keycloak-orcid)
  - [Features](#features)
  - [Compatibility](#compatibility)
  - [Installation](#installation)
  - [How to use it](#how-to-use-it)
    - [Requirements](#requirements)
    - [Configuration](#configuration)
      - [Mappers](#mappers)
      - [Theme](#theme)
  - [Q&A](#qa)
  - [How to contribute](#how-to-contribute)

This [Keycloak](https://www.keycloak.org) plugin makes possible to add [ORCID](https://orcid.org/) as Social Identity Provider.
[ORCID](https://orcid.org/)  is one of the most popular authentication options for research & education scenarios, including access to the European Open Science Cloud (EOSC).
Although ORCID can be configured as an OpenID Connect Identity Provider, the current ORCID OP implementation does not support the release of email and other information (see ORCID OpenID Connect documentation).

## Features

* Signature verification (based on client-secret)
* User account warranty level (eIDAS) required on authorization request (cf [communication FranceConnect](https://dev.entrouvert.org/issues/34448))
* Login themes with FranceConnect buttons (fc-theme and iron-theme)
* Better management for logout (https://issues.jboss.org/browse/KEYCLOAK-7209)

## Compatibility

Compatible with Keycloak version 15.0.2.

## Installation

The plugin installation is simple and can be done without a Keycloak server restart.

* Download the latest release from the [releases page](https://github.com/eosc-kc/keycloak-orcid/releases)
* Copy the JAR file into the `standalone/deployments` directory in your Keycloak server's root
* Restart Keycloak (optional, hot deployment should work)

Build with command : mvn clean install

## How to use it

### Requirements

### Configuration

Once the installation is complete, the `ORCID` identity provider appears. 

Create new ORCID Identity Provider, enter your clientId, clientSecret.
The configured alias (`france-connect-particulier`) is used by `fc-theme` and `iron-theme` themes. You can rename this alias if you don't use one of theses themes.

You will also find the redirect uri you will need to enter on the ORCID dev tools:
* URI: `https://<keycloak-url>/auth/realms/<realm>/broker/orcid/endpoint` 

#### Mappers

Once the configuration validated, you can add the mappers needed to retrieve the attributes you want.

#### Theme

This plugin provide the theme:
* `orcid-theme`

You could change he login theme to `orcid-theme` from `Themes` tab in realm settings.

