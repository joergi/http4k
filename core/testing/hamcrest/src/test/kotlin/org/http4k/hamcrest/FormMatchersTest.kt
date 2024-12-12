package org.http4k.hamcrest

import org.hamcrest.Matchers.equalTo
import org.hamcrest.core.StringContains
import org.http4k.core.with
import org.http4k.lens.FormField
import org.http4k.lens.WebForm
import org.junit.jupiter.api.Test

class FormMatchersTest {
    @Test
    fun formField() =
        FormField.required("name").let {
            assertMatchAndNonMatch(WebForm().with(it of "bob"), hasFormField(it, StringContains.containsString("bob")), hasFormField(it, equalTo("bill")))
        }
}
