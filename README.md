de.scravy : pair
================

Every know and then I found myself badly needing (wanting?) a Pair.
A lot of libraries ship with either their own definition of a pair or
pull in other libraries that provide one. But why should I use
yet-another-utility-belt (most probably in addition to the one I already pulled
in) *just for having a Pair class* when I do not need anything else from it?

It's in Maven Central
---------------------

	<dependency>
		<groupId>de.scravy</groupId>
		<artifactId>pair</artifactId>
		<version>1.0.0</version>
	</dependency>

It's easy to use
----------------

	Pair<Integer, Integer> myPair = Pairs.from(1, 2);
	
You want a comparable pair?

	Pair<String, Integer> myPair = Pairs.fromComparables("foo", 42);
	
Contributing
------------

I do not see much that could be contributed, but if you have a crazy
idea (maybe a handy utility function for `Pairs`), find a really bad bug, or
whatever - please open an issue, send me a pull request, or mail me a patch.

License
-------

MIT 