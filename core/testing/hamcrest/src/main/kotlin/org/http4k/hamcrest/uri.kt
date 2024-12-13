package org.http4k.hamcrest

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matcher
import org.hamcrest.Matchers.hasProperty
import org.hamcrest.Matchers.matchesPattern
import org.http4k.core.Uri

fun hasUriPath(matcher: Matcher<String?>): Matcher<Uri> = hasProperty("path", matcher)

fun hasUriPath(expected: String): Matcher<Uri> = hasUriPath(equalTo(expected))

fun hasUriPath(expected: Regex): Matcher<Uri> = hasProperty("name", present(matchesPattern(expected.pattern)))

fun hasUriQuery(expected: String): Matcher<Uri> = hasProperty("query", equalTo(expected))

fun hasAuthority(expected: String): Matcher<Uri> = hasProperty("authority", equalTo(expected))

fun hasHost(expected: String): Matcher<Uri> = hasProperty("host", equalTo(expected))

fun hasPort(expected: Int): Matcher<Uri> = hasProperty("port", equalTo(expected))
