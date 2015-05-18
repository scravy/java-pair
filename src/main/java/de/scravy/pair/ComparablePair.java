package de.scravy.pair;

/**
 * A {@link Pair} which is {@link Comparable}.
 * 
 * @author Julian Fleischer
 * 
 * @since 1.0.0
 *
 * @param <First>
 *          The type of the first (left) component.
 * @param <Second>
 *          The type of the second (right) component.
 */
public interface ComparablePair<First extends Comparable<? super First>, Second extends Comparable<? super Second>>
    extends Pair<First, Second>, Comparable<ComparablePair<First, Second>> {

}