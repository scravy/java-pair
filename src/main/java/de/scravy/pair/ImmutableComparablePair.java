package de.scravy.pair;

import lombok.Value;
import lombok.experimental.Wither;

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
@Value
class ImmutableComparablePair<First extends Comparable<? super First>, Second extends Comparable<? super Second>>
    implements ComparablePair<First, Second>,
    Comparable<ComparablePair<First, Second>> {

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
  public int compareTo(final ComparablePair<First, Second> other) {
    return Pairs.compare(this.first, this.second, other.getFirst(),
        other.getSecond());
  }
}