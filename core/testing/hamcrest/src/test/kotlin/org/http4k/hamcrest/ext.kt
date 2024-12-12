package org.http4k.hamcrest

import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.assertThrows

fun <T> assertMatchAndNonMatch(t: T, match: Matcher<T>, mismatch: Matcher<T>) {
    assertThat(t, match)
    assertThrows<AssertionError> { assertThat(t, mismatch) }
}
