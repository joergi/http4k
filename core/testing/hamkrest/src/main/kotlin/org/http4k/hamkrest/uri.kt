package org.http4k.hamkrest

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.has
import com.natpryce.hamkrest.matches
import com.natpryce.hamkrest.present
import org.http4k.core.Uri

fun hasUriPath(matcher: Matcher<String?>): Matcher<Uri> = has("Path", { u: Uri -> u.path }, matcher)

fun hasUriPath(expected: String): Matcher<Uri> = hasUriPath(equalTo(expected))

fun hasUriPath(expected: Regex): Matcher<Uri> = hasUriPath(present(matches(expected)))

fun hasUriQuery(expected: String): Matcher<Uri> = has("Query", { u: Uri -> u.query }, equalTo(expected))

fun hasAuthority(expected: String): Matcher<Uri> = has("Authority", { u: Uri -> u.authority }, equalTo(expected))

fun hasHost(expected: String): Matcher<Uri> = has("Host", { u: Uri -> u.host }, equalTo(expected))

fun hasPort(expected: Int): Matcher<Uri> = has("Port", { u: Uri -> u.port }, equalTo(expected))
