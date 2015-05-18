package de.scravy.pair;

import lombok.Value;
import lombok.experimental.Wither;

@Value
public class ComparablePair<First extends Comparable<? super First>, Second extends Comparable<? super Second>>
    implements Pair<First, Second>, Comparable<ComparablePair<First, Second>> {

  private final @Wither First first;
  private final @Wither Second second;
  
  @Override
  public int compareTo(final ComparablePair<First, Second> other) {
    return Pairs.compare(first, second, other.first, other.second);
  }
}