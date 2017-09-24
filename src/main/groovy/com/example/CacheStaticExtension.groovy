package com.example

import com.google.common.base.Function
import com.google.common.base.Supplier
import com.google.common.cache.CacheLoader

class CacheStaticExtension {
	// seems that from() as more then one implementation which causes aubiguity
    public static CacheLoader from(/*CacheLoader loader, */Closure cl) {
        CacheLoader.from(cl as Function)
    }
}
