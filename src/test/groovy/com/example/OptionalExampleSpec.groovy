package com.example

import spock.lang.Specification
// import spock.lang.Unroll
import spock.lang.*
import spock.util.mop.Use

class OptionalExampleSpec extends Specification {

	OptionalExample tester

	def setup(){
		tester = new OptionalExample()
	}
	
	// @IgnoreRest // ignor other tests
	def 'should return sum of 5'(){
		when:
			def i = null
			def j = new Integer(5)
		then:
			tester.sumInt(i,j)==5
	}
	
	@IgnoreIf({ !System.getProperty("os.name").contains("windows") })
	def 'we are running on Windows machine'(){
		expect:
			System.getProperty("os.name").contains('windows')
	}
	
	@Ignore
	def 'minimal spock test'(){
		expect:
			Math.sqrt(9) == 3.0	
	}
	
	@Ignore /*(reason = "Example") */
	def 'simple given-when-then test'(){
		given: //'two Integer values'
			int x = 2
			int y = 3
		when: //'we sum two values and one of them is null'
			def sum = x + y
		then: //'we get the total considering the null value as zero'
			5 == sum	
	}
	
	@Unroll // @Unroll is optional, it allows to test each rows in data table one by one
	def 'expected string length'(){
		expect:
			lang.length() == len
		where:
			// here we use Data Tables
			lang	| len
			'Groovy'| 6
			'Java'	| 4
			'Spock'	| 5
			'Grails'| 6
	}
	
	// Extensions: Stubbing for Dynamic methods
	class ListExtension {
	  static avg(List list) { list.sum() / list.size() }
	}	
		
	// now List class has avg() method
	@Use(ListExtension)
	def "can use avg() method"() {
		expect:
		[1, 2, 3].avg() == 2
	}	

}