/**
 * <p>This package provides ordered pairs that consist of a first (left)
 * and a second (right) component. There are four pair types defined
 * as the following interfaces:
 *
 * <ul>
 *   <li>{@link de.scravy.pair.Pair}
 *   <li>{@link de.scravy.pair.ComparablePair}
 *   <li>{@link de.scravy.pair.SerializablePair}
 *   <li>{@link de.scravy.pair.ComparableSerializablePair}
 * </ul>
 *
 * <p>Instances of this classes can be created using the
 * {@link de.scravy.pair.Pairs} utility class. For every interface
 * there is a static builder function:
 *
 * <ul>
 *    <li>{@link de.scravy.pair.Pairs#from(Object, Object)}
 *      - creates a simple Pair.
 *    <li>{@link de.scravy.pair.Pairs#fromComparables(Comparable, Comparable)}
 *      - creates a Pair from Comparables. The Pair is itself comparable.
 *    <li>{@link de.scravy.pair.Pairs#fromSerializables(java.io.Serializable, java.io.Serializable)}
 *      - creates a Pair from Serializables. The Pair is itself serializable.
 *    <li>{@link de.scravy.pair.Pairs#fromComparableSerializables(java.io.Serializable, java.io.Serializable)}
 *      - creates a Pair from components that are both {@link java.lang.Comparable} and {@link java.io.Serializable}.
 *        The Pair is itself comparable and serializable.
 *  </ul>
 *
 *  <p>All instances that can be created using this package are immutable and
 *  defining interfaces do not suggest setters/mutability. This is also the reason
 *  why the Pairs here do not extend {@link java.util.Map.Entry} (unlinke e.g. the
 *  Apache Commons Pair).
 *
 * <h2>Motivation</h2>
 *
 * <p>Every know and then I found myself badly needing (wanting?) a Pair.
 * A lot of libraries ship with either their own definition of a pair or
 * pull in other libraries that provide one. But why should I use yet-another-utility-belt
 * (most probably in addition to the one I already pulled in)
 * <i>just for having a Pair class</i> when I do not need anything else from it?
 *
 * @author Julian Fleischer
 * @since 1.0.0
 */
package de.scravy.pair;

