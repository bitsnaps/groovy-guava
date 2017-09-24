package com.example

import com.google.common.base.Optional;

class OptionalExample{

  static main(args){
	Integer x = null
	Integer y = new Integer(5)
	Optional<Integer> i = Optional.fromNullable(x);
	Optional<Integer> j = Optional.of(y);
	
    assert (sum(i, j) == 5)
    println('done')
  }
  
  public Integer sumInt(Integer x, Integer y){
	new OptionalExample().sum(Optional.fromNullable(x), Optional.of(y))
  }
  
  static def sum(Optional<Integer> x, Optional<Integer> y){
	x.or(0) + y.get()
  }
}