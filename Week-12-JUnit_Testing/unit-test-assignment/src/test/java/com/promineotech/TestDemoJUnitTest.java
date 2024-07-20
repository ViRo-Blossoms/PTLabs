package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

private static TestDemo testDemo;
private static ViRoDemo viroDemo;

@BeforeEach
void setUp() throws Exception {
	testDemo = new TestDemo();
	viroDemo = new ViRoDemo();
	
} //SU

@ParameterizedTest
@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
	if(!expectException) 
	{
		assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
	}
	else if(expectException)
	{
		assertThatThrownBy(() -> testDemo.addPositive(a,b))
			.isInstanceOf(IllegalArgumentException.class);
	}
} //ATTPNAAC

static Stream<Arguments> argumentsForAddPositive() {
	return Stream.of(
			Arguments.of(1, 1, 2, false), Arguments.of(39, 1, 40, false), 
			Arguments.of(1, 999, 1000, false), Arguments.of(-1, 1, 0, true), 
			Arguments.of(6, -9, 3, true), Arguments.of(-1, -1, -2, true)
			);//STREAM
} //AFAP

@Test
static void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
} //ATPOPNAAC

@Test
void assertThatNumberSquaredIsCorrect() {
	TestDemo mockDemo = spy(testDemo);
	doReturn(5).when(mockDemo).getRandomInt();
	int fiveSquared = mockDemo.randomNumberSquared();
	assertThat(fiveSquared).isEqualTo(25);
} //ATNSIC

@ParameterizedTest
@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForScaryuser")
void usernameOfTheGuyWhoIsStandingOnTheObjectiveAndIAmNotSureIfIWillImmeadietlyLoseThisFight(String username, boolean expectedScary) {
	if (expectedScary == true)
	{
		assertTrue(viroDemo.isUserScary(username));
	}
	else if (expectedScary == false)
	{
		assertFalse(viroDemo.isUserScary(username));
	}
	else
	{
		System.err.println("Uh-Oh!!");
	}
} //UOTGWISOTOAIANSIIWILTF

static Stream<Arguments> argumentsForScaryuser() {
	return Stream.of(
			Arguments.of("ViRo", false), Arguments.of("Jimmy292158497", false), //Not in list, false
			Arguments.of("Star_", true), Arguments.of("b4nny", true), //In list, true
			Arguments.of("xX_SnIpErWuLfE_Xx", false), Arguments.of("E", false), //Not in list, short and long
			Arguments.of("aim", true), Arguments.of("Pablo.gonzales.2007", true), //In list, short and long
			Arguments.of("", false), Arguments.of("                  ", false), //Empty and Blank
			Arguments.of("soooooapYMEister", true), Arguments.of("YOMPS", true) //In list with mishaps
			// TEST TEST Arguments.of("ViRo", true), Arguments.of("Jimmy292158497", true) //Not in list, expected fails
			);//STREAM
} //AFSU
} //CLASS
