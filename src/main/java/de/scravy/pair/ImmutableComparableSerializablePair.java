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
class ImmutableComparableSerializablePair<First extends Serializable & Comparable<? super First>, Second extends Serializable & Comparable<? super Second>>
    implements ComparableSerializablePair<First, Second>,
    Comparable<ComparableSerializablePair<First, Second>>, Serializable {

  private static final long serialVersionUID = 1L;

  private final @Wither First first;
  private final @Wither Second second;

  @Override
  public boolean equals(final Object other) {
    return Pairs.equals(this, other);
  }

  @Override
  public int hashCode() {
    return Pairs.hashCode(this);
  }

  @Override
  public int compareTo(final ComparableSerializablePair<First, Second> other) {
    return Pairs.compare(this.first, this.second, other.getFirst(),
        other.getSecond());
  }
}