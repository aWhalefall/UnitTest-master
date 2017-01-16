package com.czt.saisam.unittest.util.junit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.DescribedAs.describedAs;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.any;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.IsSame.sameInstance;

/**
 * Created by weichyang on 2017/1/10.
 * blog url: http://edgibbs.com/junit-4-with-hamcrest/
 */

public class Harmscret {


    @Test
    public void allOfExampleShowsAllMatchersMustAllBeTrue() throws Exception {
        assertThat("Hello", is(allOf(notNullValue(), instanceOf(String.class), equalTo("Hello"))));
    }

    @Test
    public void allOfExampleShowsFailingIfOneMatcherDoesNotMatch() throws Exception {
        assertThat("Hello", is(not(allOf(notNullValue(), instanceOf(Integer.class)))));
    }

    @Test
    public void anyExampleChecksThatClassIsOfSameType() throws Exception {
        assertThat("Hello", is(any(String.class)));
    }

    @Test
    public void anyExampleShowsStringIsAlsoAnObject() throws Exception {
        assertThat("Hello", is(any(Object.class)));
    }

    @Test
    public void anyOfExampleReturnsTrueIfOneMatches() throws Exception {
        assertThat("Hello", is(anyOf(nullValue(), instanceOf(String.class), equalTo("Goodbye"))));
    }

    @Test
    public void anyOfExampleFailingIfAllMatchersAreFalse() throws Exception {
        assertThat("Hello", is(not(anyOf(nullValue(), instanceOf(Integer.class), equalTo("Goodbye")))));
    }

    @Test
    public void anythingExampleAlwaysReturnsTrue() throws Exception {
        assertThat("Hello", is(anything()));
    }

    // Feels very esoteric and not for typical usage used to override the description
    @Test
    public void describedAsExample() throws Exception {
        Matcher<?> matcher = describedAs("My Description", anything());
        Description description = new StringDescription().appendDescriptionOf(matcher);
        assertThat("My Description", is(description.toString()));
    }

    @Test
    public void equalToExampleAddingTwoPlusTwo() throws Exception {
        assertThat(2 + 2, is(equalTo(4)));
    }

    @Test
    public void instanceOfExampleForString() throws Exception {
        assertThat("Hello", is(instanceOf(String.class)));
    }

    @Test
    public void isExampleShortCutForIsInstanceOfClass() throws Exception {
        assertThat("Hello", is(String.class));
        assertThat("Hello", instanceOf(String.class));
    }

    @Test
    public void isExampleShortCutAsJustSyntacticSugarUsedThreeTimes() throws Exception {
        assertThat("Hello", is(is(is(notNullValue()))));
    }

    @Test
    public void isExampleShortCutForIsEqualTo() throws Exception {
        assertThat("Hello", is("Hello"));
        assertThat("Hello", equalTo("Hello"));
    }

    @Test
    public void notExampleJustInvertsExpression() throws Exception {
        assertThat("Hello", is(not(instanceOf(Integer.class))));
    }

    @Test
    public void notNullValueExampleForString() throws Exception {
        assertThat("Hello", is(notNullValue()));
    }

    @Test
    public void notNullValueExampleForAClass() throws Exception {
        assertThat("Hello", is(notNullValue(Object.class)));
    }

    @Test
    public void nullValueExampleWithANull() throws Exception {
        assertThat(null, is(nullValue()));
    }

    @Test
    public void nullValueExampleWithANullType() throws Exception {
        Integer nothing = null;
        assertThat(nothing, is(nullValue(Integer.class)));
    }

    @Test
    public void sameInstanceExample() throws Exception {
        Object object = new Object();
        Object sameObject = object;
        assertThat(object, is(sameInstance(sameObject)));
    }

}
