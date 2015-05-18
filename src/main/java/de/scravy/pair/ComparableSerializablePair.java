package de.scravy.pair;

import java.io.Serializable;

import lombok.Value;
import lombok.experimental.Wither;

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
@Value
public class ComparableSerializablePair<First extends Serializable & Comparable<? super First>, Second extends Serializable & Comparable<? super Second>>
    implements Pair<First, Second>,
    Comparable<ComparableSerializablePair<First, Second>>, Serializable {

  private static final long serialVersionUID = 1L;

  private final @Wither First first;
  private final @Wither Second second;

  @Override
  public int compareTo(final ComparableSerializablePair<First, Second> other) {
    return Pairs.compare(first, second, other.first, other.second);
  }
}