package de.scravy.pair;

import lombok.Value;
import lombok.experimental.Wither;

@Value
public class SimplePair<First, Second> implements Pair<First, Second> {

  private final @Wither First first;
  private final @Wither Second second;

}
