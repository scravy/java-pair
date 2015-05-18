package de.scravy.pair;

import java.io.Serializable;

/**
 * A {@link Pair} which is both {@link Comparable} and {@link Serializable}.
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
public interface ComparableSerializablePair<First extends Serializable & Comparable<? super First>, Second extends Serializable & Comparable<? super Second>>
    extends Pair<First, Second>,
    Comparable<ComparableSerializablePair<First, Second>>, Serializable {

}