import org.http4k.internal.ModuleLicense.Apache2

description = "A set of Java Hamcrest matchers for common http4k types"

val license by project.extra { Apache2 }

plugins {
    id("org.http4k.community")
}

dependencies {
    api(project(":http4k-core"))
    implementation(project(":http4k-format-core"))
    api("org.hamcrest:hamcrest:_")
    testImplementation(project(":http4k-format-jackson"))
}
