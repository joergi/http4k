package org.http4k.hamcrest

//import com.natpryce.hamkrest.Matcher
//import com.natpryce.hamkrest.equalTo
//import com.natpryce.hamkrest.has
//import com.natpryce.hamkrest.present
//import jdk.internal.classfile.impl.Util.has
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Matcher
import org.hamcrest.Matchers.hasProperty
import org.http4k.core.cookie.Cookie
import org.http4k.core.cookie.SameSite
import java.time.Instant

fun hasCookieName(expected: CharSequence): Matcher<Cookie> = hasProperty("name", equalTo(expected))


@JvmName("hasCookieValueNullableString")
fun hasCookieValue(matcher: Matcher<String?>): Matcher<Cookie> = hasProperty("value", matcher)

fun hasCookieValue(matcher: Matcher<String>): Matcher<Cookie> = has(Cookie::value, present(matcher))

fun hasCookieValue(expected: CharSequence): Matcher<Cookie> = hasProperty("value", equalTo(expected))

fun hasCookieDomain(expected: CharSequence): Matcher<Cookie> = hasProperty("domain", equalTo(expected))

fun hasCookiePath(expected: CharSequence): Matcher<Cookie> = hasProperty("path", equalTo(expected))

fun isSecureCookie(expected: Boolean = true): Matcher<Cookie> = hasProperty("secure", equalTo(expected))

fun isHttpOnlyCookie(expected: Boolean = true): Matcher<Cookie> = hasProperty("httpOnly", equalTo(expected))

fun hasCookieExpiry(expected: Instant): Matcher<Cookie> = hasCookieExpiry(equalTo(expected))

fun hasCookieExpiry(matcher: Matcher<Instant>): Matcher<Cookie> = has("expiry", { c: Cookie -> c.expires!! }, matcher)
//fun hasCookieExpiry(matcher: Matcher<Instant>): Matcher<Cookie> = hasProperty("expires", matcher)

fun hasCookieSameSite(expected: SameSite): Matcher<Cookie> = hasProperty("sameSite", equalTo(expected))
