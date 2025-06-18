package ai.idealistic.vacan.utils.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jetbrains.annotations.NotNull;

public class b<E> implements List<E> {
   private final List<E> jM;
   private final int ka;
   private int kb;

   public b(List<E> var1, int var2) {
      this.jM = var1;
      this.ka = var2;
      this.kb = 0;
   }

   public int size() {
      return this.jM.size();
   }

   public boolean isEmpty() {
      return this.jM.isEmpty();
   }

   public boolean contains(Object var1) {
      return this.jM.contains(var1);
   }

   @NotNull
   public Iterator<E> iterator() {
      Iterator var10000 = this.jM.iterator();
      if (var10000 == null) {
         d(0);
      }

      return var10000;
   }

   @NotNull
   public Object[] toArray() {
      Object[] var10000 = this.jM.toArray();
      if (var10000 == null) {
         d(1);
      }

      return var10000;
   }

   @NotNull
   public <T> T[] toArray(@NotNull T[] var1) {
      if (var1 == null) {
         d(2);
      }

      Object[] var10000 = this.jM.toArray(var1);
      if (var10000 == null) {
         d(3);
      }

      return var10000;
   }

   public boolean add(E var1) {
      if (this.jM.size() == this.ka) {
         this.jM.set(this.kb, var1);
         ++this.kb;
         if (this.kb == this.ka) {
            this.kb = 0;
         }

         return true;
      } else {
         return this.jM.add(var1);
      }
   }

   public boolean remove(Object var1) {
      if (this.jM.remove(var1)) {
         this.kb = 0;
         return true;
      } else {
         return false;
      }
   }

   public boolean containsAll(@NotNull Collection<?> var1) {
      if (var1 == null) {
         d(4);
      }

      return (new HashSet(this.jM)).containsAll(var1);
   }

   public boolean addAll(@NotNull Collection<? extends E> var1) {
      if (var1 == null) {
         d(5);
      }

      throw new UnsupportedOperationException();
   }

   public boolean addAll(int var1, @NotNull Collection<? extends E> var2) {
      if (var2 == null) {
         d(6);
      }

      throw new UnsupportedOperationException();
   }

   public boolean removeAll(@NotNull Collection<?> var1) {
      if (var1 == null) {
         d(7);
      }

      if (this.jM.removeAll(var1)) {
         this.kb = 0;
         return true;
      } else {
         return false;
      }
   }

   public boolean retainAll(@NotNull Collection<?> var1) {
      if (var1 == null) {
         d(8);
      }

      if (this.jM.retainAll(var1)) {
         this.kb = 0;
         return true;
      } else {
         return false;
      }
   }

   public void clear() {
      this.jM.clear();
      this.kb = 0;
   }

   public boolean equals(Object var1) {
      return this.jM.equals(var1);
   }

   public int hashCode() {
      return this.jM.hashCode();
   }

   public E get(int var1) {
      return this.jM.get(var1);
   }

   public E set(int var1, E var2) {
      return this.jM.set(var1, var2);
   }

   public void add(int var1, E var2) {
      this.jM.add(var1, var2);
   }

   public E remove(int var1) {
      return this.jM.remove(var1);
   }

   public int indexOf(Object var1) {
      return this.jM.indexOf(var1);
   }

   public int lastIndexOf(Object var1) {
      return this.jM.lastIndexOf(var1);
   }

   @NotNull
   public ListIterator<E> listIterator() {
      ListIterator var10000 = this.jM.listIterator();
      if (var10000 == null) {
         d(9);
      }

      return var10000;
   }

   @NotNull
   public ListIterator<E> listIterator(int var1) {
      ListIterator var10000 = this.jM.listIterator(var1);
      if (var10000 == null) {
         d(10);
      }

      return var10000;
   }

   @NotNull
   public List<E> subList(int var1, int var2) {
      List var10000 = this.jM.subList(var1, var2);
      if (var10000 == null) {
         d(11);
      }

      return var10000;
   }

   // $FF: synthetic method
   private static void d(int var0) {
      String var10000;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 9:
      case 10:
      case 11:
      default:
         var10000 = "@NotNull method %s.%s must not return null";
         break;
      case 2:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
         var10000 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
      }

      byte var10001;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 9:
      case 10:
      case 11:
      default:
         var10001 = 2;
         break;
      case 2:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
         var10001 = 3;
      }

      Object[] var2 = new Object[var10001];
      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 9:
      case 10:
      case 11:
      default:
         var2[0] = "ai/idealistic/vacan/utils/java/OverflowList";
         break;
      case 2:
         var2[0] = "a";
         break;
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
         var2[0] = "c";
      }

      switch(var0) {
      case 0:
      default:
         var2[1] = "iterator";
         break;
      case 1:
      case 3:
         var2[1] = "toArray";
         break;
      case 2:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
         var2[1] = "ai/idealistic/vacan/utils/java/OverflowList";
         break;
      case 9:
      case 10:
         var2[1] = "listIterator";
         break;
      case 11:
         var2[1] = "subList";
      }

      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 9:
      case 10:
      case 11:
      default:
         break;
      case 2:
         var2[2] = "toArray";
         break;
      case 4:
         var2[2] = "containsAll";
         break;
      case 5:
      case 6:
         var2[2] = "addAll";
         break;
      case 7:
         var2[2] = "removeAll";
         break;
      case 8:
         var2[2] = "retainAll";
      }

      var10000 = String.format(var10000, var2);
      Object var1;
      String var4;
      switch(var0) {
      case 0:
      case 1:
      case 3:
      case 9:
      case 10:
      case 11:
      default:
         IllegalStateException var3 = new IllegalStateException;
         var4 = var10000;
         var1 = var3;
         var3.<init>(var4);
         break;
      case 2:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
         IllegalArgumentException var10002 = new IllegalArgumentException;
         var4 = var10000;
         var1 = var10002;
         var10002.<init>(var4);
      }

      throw var1;
   }
}
