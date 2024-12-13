package org.http4k.hamcrest

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


fun <T> present(valueMatcher: Matcher<T>? = null): Matcher<T?> {
    return object : TypeSafeMatcher<T?>() {
        override fun describeTo(description: Description) {
            description.appendText("is not null")
            if (valueMatcher != null) {
                description.appendText(" & ").appendDescriptionOf(valueMatcher)
            }
        }

        override fun matchesSafely(item: T?): Boolean {
            return item != null && (valueMatcher == null || valueMatcher.matches(item))
        }

        override fun describeMismatchSafely(item: T?, mismatchDescription: Description) {
            if (item == null) {
                mismatchDescription.appendText("was null")
            } else if (valueMatcher != null) {
                valueMatcher.describeMismatch(item, mismatchDescription)
            }
        }
    }
}
