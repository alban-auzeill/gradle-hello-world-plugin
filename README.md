# Hello World Gradle Plugin

Based on the Gradle documentation:
- https://docs.gradle.org/current/userguide/writing_plugins.html
- https://docs.gradle.org/current/userguide/publishing_gradle_plugins.html
- https://plugins.gradle.org/docs/publish-plugin

## Build the plugin

```bash
./gradlew build
```

## Sign the plugin

```bash
gpg --keyring secring.gpg --export-secret-keys > ~/.gnupg/secring.gpg    

gpg --list-secret-keys --keyring ~/.gnupg/secring.gpg

export ORG_GRADLE_PROJECT_secretKeyRingFile="${HOME}/.gnupg/secring.gpg"
export ORG_GRADLE_PROJECT_signingKey="*****************************"
export ORG_GRADLE_PROJECT_signingPassword="*************************"

./gradlew signGreetingPluginPluginMarkerMavenPublication \
  -Psigning.secretKeyRingFile="${ORG_GRADLE_PROJECT_secretKeyRingFile}" \
  -Psigning.keyId="${ORG_GRADLE_PROJECT_signingKey}" \
  -Psigning.password="${ORG_GRADLE_PROJECT_signingPassword}"
```

## Publish the plugin to the Gradle Plugin portal

```bash
export GRADLE_PUBLISH_KEY="********************************"
export GRADLE_PUBLISH_SECRET="********************************"

export ORG_GRADLE_PROJECT_secretKeyRingFile="${HOME}/.gnupg/secring.gpg"
export ORG_GRADLE_PROJECT_signingKey="*****************************"
export ORG_GRADLE_PROJECT_signingPassword="*************************"

./gradlew publishPlugins \
  -Psigning.secretKeyRingFile="${ORG_GRADLE_PROJECT_secretKeyRingFile}" \
  -Psigning.keyId="${ORG_GRADLE_PROJECT_signingKey}" \
  -Psigning.password="${ORG_GRADLE_PROJECT_signingPassword}" \
  --validate-only
```
