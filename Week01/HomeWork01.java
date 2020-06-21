package cn.guoting.week01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Lei Guoting on 2020/6/14.
 */
public class HomeWork01 {

  public static void main(String[] args) {
    Deque<String> deque = new LinkedList<>();
    deque.addFirst("a");
    deque.addFirst("b");
    deque.addFirst("c");
    System.out.println(deque);

    String str = deque.peekFirst();
    System.out.println(str);
    System.out.println(deque);

    while (deque.size() > 0) {
      System.out.println(deque.removeFirst());
    }
    System.out.println(deque);

    /*
     * print:
     * [c, b, a]
     * c
     * [c, b, a]
     * c
     * b
     * a
     * []
     */
  }
}
