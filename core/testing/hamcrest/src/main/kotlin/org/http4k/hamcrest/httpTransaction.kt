package org.http4k.hamcrest

import org.hamcrest.Matcher
import org.hamcrest.Matchers.hasProperty
import org.http4k.core.HttpTransaction
import org.http4k.core.Request
import org.http4k.core.Response

fun hasRequest(matcher: Matcher<Request>): Matcher<HttpTransaction> = hasProperty("request", matcher)
fun hasResponse(matcher: Matcher<Response>): Matcher<HttpTransaction> = hasProperty("response", matcher)
