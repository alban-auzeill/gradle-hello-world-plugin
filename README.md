# Hello World Gradle Plugin

Based on the Gradle documentation:
- https://docs.gradle.org/current/userguide/writing_plugins.html
- https://docs.gradle.org/current/userguide/publishing_gradle_plugins.html
- https://plugins.gradle.org/docs/publish-plugin

## Build the plugin

```bash
./gradlew build
```

## Publish the plugin to the Gradle Plugin portal

```bash
export GRADLE_PUBLISH_KEY="********************************"
export GRADLE_PUBLISH_SECRET="********************************"
./gradlew publishPlugins
```
