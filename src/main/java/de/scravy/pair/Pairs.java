package de.scravy.pair;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Map;

import lombok.experimental.UtilityClass;

/**
 * Static methods for dealing with all sorts of pairs.
 * 
 * @since 1.0.0
 * 
 * @author Julian Fleischer
 */
@UtilityClass
public class Pairs {

  /**
   * Create a simple pair from it's first and second component.
   * 
   * @since 1.0.0
   * 
   * @param first
   *          The first (left) component.
   * @param second
   *          The second (right) component.
   * @return A pair consisting of the two components.
   */
  public static <First, Second> Pair<First, Second> from(
      final First first, final Second second) {
    return new ImmutablePair<First, Second>(first, second);
  }

  /**
   * Creates a pair from comparables which is itself {@link Comparable}.
   * 
   * @since 1.0.0
   * 
   * @param first
   *          The first (left) component.
   * @param second
   *          The second (right) component.
   * @return A comparable pair consisting of the two components.
   */
  public static <First extends Comparable<? super First>, Second extends Comparable<? super Second>>
      ComparablePair<First, Second> fromComparables(
          final First first, final Second second) {
    return new ImmutableComparablePair<First, Second>(first, second);
  }

  /**
   * Creates a pair from serializables which is itself {@link Serializable}.
   * 
   * @since 1.0.0
   * 
   * @param first
   *          The first (left) component.
   * @param second
   *          The second (right) component.
   * @return A serilizable pair consisting of the two components.
   */
  public static <First extends Serializable, Second extends Serializable>
      SerializablePair<First, Second> fromSerializables(
          final First first, final Second second) {
    return new ImmutableSerializablePair<First, Second>(first, second);
  }

  /**
   * Creates a pair from components which are comparable and serializable which
   * is itself {@link Comparable} and {@link Serializable}.
   * 
   * @since 1.0.0
   * 
   * @param first
   *          The first (left) component.
   * @param second
   *          The second (right) component.
   * @return A serilizable pair consisting of the two components.
   */
  public static <First extends Serializable & Comparable<? super First>, Second extends Serializable & Comparable<? super Second>>
      ComparableSerializablePair<First, Second> fromComparableSerializables(
          final First first, final Second second) {
    return new ImmutableComparableSerializablePair<First, Second>(first, second);
  }

  /**
   * Transform a pair into an array of the common super type of both components.
   * 
   * @param pair
   *          The pair.
   * @param commonSuperType
   *          A common super type that both First and Second inherit from.
   * @return The array of the common super type with length 2.
   */
  public static <CommonSuperType, First extends CommonSuperType, Second extends CommonSuperType>
      CommonSuperType[] toArray(final Pair<First, Second> pair,
          final Class<CommonSuperType> commonSuperType) {
    @SuppressWarnings("unchecked")
    final CommonSuperType[] array = (CommonSuperType[]) Array.newInstance(
        commonSuperType, 2);
    return toArray(pair, array, 0);
  }

  /**
   * Write a pair into an array of the common super type of both components.
   * 
   * @param pair
   *          The pair.
   * @return The array of the common super type with length 2.
   */
  public static <CommonSuperType, First extends CommonSuperType, Second extends CommonSuperType>
      CommonSuperType[] toArray(
          final Pair<First, Second> pair,
          final CommonSuperType[] target, final int offset) {
    target[offset] = pair.getFirst();
    target[offset + 1] = pair.getSecond();
    return target;
  }

  public static <First extends Comparable<? super First>, Second extends Comparable<? super Second>>
      int compare(
          final Pair<First, Second> left,
          final Pair<First, Second> right) {

    return compare(
        left.getFirst(), left.getSecond(), right.getFirst(), right.getSecond());
  }

  public static <First extends Comparable<? super First>, Second extends Comparable<? super Second>>
      int compare(
          final First firstOfLeft, final Second secondOfLeft,
          final First firstOfRight, final Second secondOfRight) {

    // (?, ?) and (?, ?)

    if (firstOfLeft == null) {
      // (null, ?) and (?, ?)
      if (firstOfRight == null) {
        // (null, ?) and (null, ?)
        if (secondOfLeft == null) {
          // (null, null) and (null, ?)
          if (secondOfRight == null) {
            // (null, null) and (null, null)
            return 0;
          } else {
            // (null, null) and (null, /something/)
            return -1;
          }
        } else {
          if (secondOfRight == null) {
            // (null, /something/) and (null, null)
            return 1;
          } else {
            // (null, /something/) and (null, /something/)
            return secondOfLeft.compareTo(secondOfRight);
          }
        }
      }
      // (null, ?) and (/something/, ?)
      return 1;
    }
    // (/something/, ?) and (/something/, ?)
    final int comparisonOfFirsts = firstOfLeft.compareTo(firstOfRight);
    if (comparisonOfFirsts != 0) {
      return comparisonOfFirsts;
    }
    // (x, ?) and (x, ?)
    if (secondOfLeft == null) {
      // (x, null) and (x, ?)
      if (secondOfRight == null) {
        // (x, null) and (x, null)
        return 0;
      } else {
        // (x, null) and (x, /something/)
        return -1;
      }
    }
    // (x, /something/) and (x, ?)
    if (secondOfRight == null) {
      return 1;
    }
    // (x, /something/) and (x, /something/)
    return secondOfLeft.compareTo(secondOfRight);
  }

  public static <K, V, M extends Map<K, V>> M toMap(
      final Iterable<Pair<K, V>> pairs, final Class<M> mapType) {
    try {
      final M map = mapType.newInstance();
      return toMap(pairs, map);
    } catch (final Exception exc) {
      return null;
    }
  }

  public static <K, V, M extends Map<K, V>> M toMap(
      final Iterable<Pair<K, V>> pairs, final M map) {
    try {
      for (final Pair<K, V> pair : pairs) {
        map.put(pair.getFirst(), pair.getSecond());
      }
      return map;
    } catch (final Exception exc) {
      return null;
    }
  }
}
