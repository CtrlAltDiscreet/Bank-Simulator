
class Seq<T extends Comparable<T>> {
  private T[] seq;

  public Seq(int size) {
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Comparable[size];
    this.seq = temp;
  }

  public void set(int index, T item) {
    this.seq[index] = item;
  }

  public T get(int index) {
    return this.seq[index];
  }

  public T min() {
    T min = seq[0];
    for (int i = 0; i < seq.length; i++) {
      if (seq[i].compareTo(min) < 0) {
        min = seq[i];
      }
    }
    return min;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < this.seq.length; i++) {
      s.append(i + ":" + this.seq[i]);
      if (i != this.seq.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
