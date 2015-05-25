package de.scravy.pair;

/**
 * A pair consisting of a first (left) and a second (right) component.
 *
 * Classes implementing this interface must be final (i.e. are not allowed to
 * have subclasses) and should contain exactly two things: A first component and
 * a second component (because that is what a pair is: A first and a second
 * component, and not a first and a second component and then some).
 *
 * @author Julian Fleischer
 * @since 1.0.0
 *
 * @param <First>
 *          The type of the first (left) component.
 * @param <Second>
 *          The type of the second (right) component.
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

  /**
   * <code>equals</code> for Pairs works almost the same as for objects, minus
   * checking for whether the other object is of the same class.
   *
   * Since all pairs are final and immutable, equals is still an equivalence
   * relation and all pairs (no matter what exact type) are considered equal.
   *
   * Pairs behave like that since version 1.1.0 (unfortunately it was not yet
   * considered in version 1.0.0).
   *
   * @since 1.1.0
   *
   * @return Whether this pairs components equal the components of the other
   *         pair.
   */
  @Override
  boolean equals(final Object other);
}
