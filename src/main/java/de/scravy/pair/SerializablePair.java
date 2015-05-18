package de.scravy.pair;

import java.io.Serializable;

/**
 * A {@link Pair} which is {@link Serializable}.
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
public interface SerializablePair<First extends Serializable, Second extends Serializable>
    extends Pair<First, Second>, Serializable {

}