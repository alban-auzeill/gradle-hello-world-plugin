/*
 * This source file was generated by the Gradle 'init' task
 */
package com.auzeill.gradle;

import org.gradle.api.Project;
import org.gradle.api.Plugin;

/**
 * A simple 'hello world' plugin.
 */
public class GradleHelloWorldPluginPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getTasks().register("greeting", task -> {
            task.doLast(s -> System.out.println("Hello from plugin 'com.auzeill.gradle.greeting'"));
        });
    }
}
