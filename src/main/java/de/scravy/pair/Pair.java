package de.scravy.pair;

/**
 * A pair consisting of a first (left) and a second (right) component.
 * 
 * @author Julian Fleischer
 * @since 1.0.0
 *
 * @param <First>
 * @param <Second>
 */
public interface Pair<First, Second> {

  /**
   * Get the first (left) component of this pair.
   * 
   * @return The first component. This may include <code>null</code> in general.
   */
  First getFirst();

  /**
   * Get the second (right) component of this pair.
   * 
   * @return The second component. This may include <code>null</code> in
   *         general.
   */
  Second getSecond();
}
