package com.example

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import spock.lang.Specification
import com.google.common.base.Function
// import spock.util.mop.Use

class CacheSpec extends Specification {
	
	//@Use(CacheStaticExtension)
    def "should create a cache loader"() {
        when: "we call the static from method on CacheLoader"
			// we're not using extension here because of ambuiguity overloading (check out: CacheStaticExtension.groovy)
			def loader = CacheStaticExtension.from {str ->  str.toUpperCase() }
        then: "a cache loader is created"
            loader instanceof CacheLoader
        when: "a cache is created"
            def cache = CacheBuilder.newBuilder().build(loader)
        then: "the cache is empty"
            cache.size() == 0
        when: "we request for a key"
            def value = cache.get('foo')
        then: "the uppercase version is returned"
            value == 'FOO'
    }
}
