package ai.idealistic.vacan.utils.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

public class a<E> implements List<E> {
   private final Map<Integer, E> iP;

   public a(int var1) {
      this.iP = new ConcurrentHashMap(var1);
   }

   public a() {
      this(2);
   }

   public int size() {
      return this.iP.size();
   }

   public boolean isEmpty() {
      return this.iP.isEmpty();
   }

   public boolean contains(Object var1) {
      return this.iP.containsValue(var1);
   }

   @NotNull
   public Iterator<E> iterator() {
      Iterator var10000 = this.iP.values().iterator();
      if (var10000 == null) {
         d(0);
      }

      return var10000;
   }

   @NotNull
   public Object[] toArray() {
      Object[] var10000 = this.iP.values().toArray();
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

      Object[] var10000 = this.iP.values().toArray(var1);
      if (var10000 == null) {
         d(3);
      }

      return var10000;
   }

   public boolean add(E var1) {
      this.iP.put(this.iP.size(), var1);
      return true;
   }

   public boolean remove(Object var1) {
      Iterator var2 = this.iP.entrySet().iterator();

      Entry var3;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         var3 = (Entry)var2.next();
      } while(!var3.getValue().equals(var1));

      this.iP.remove(var3.getKey());
      return true;
   }

   public boolean containsAll(@NotNull Collection<?> var1) {
      if (var1 == null) {
         d(4);
      }

      Iterator var2 = var1.iterator();

      Object var3;
      do {
         if (!var2.hasNext()) {
            return true;
         }

         var3 = var2.next();
      } while(this.contains(var3));

      return false;
   }

   public boolean addAll(@NotNull Collection<? extends E> var1) {
      if (var1 == null) {
         d(5);
      }

      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         this.add(var3);
      }

      return true;
   }

   public boolean addAll(int var1, @NotNull Collection<? extends E> var2) {
      if (var2 == null) {
         d(6);
      }

      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         this.add(var1++, var4);
      }

      return true;
   }

   public boolean removeAll(@NotNull Collection<?> var1) {
      if (var1 == null) {
         d(7);
      }

      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         this.remove(var3);
      }

      return true;
   }

   public boolean retainAll(@NotNull Collection<?> var1) {
      if (var1 == null) {
         d(8);
      }

      boolean var2 = false;
      Iterator var3 = this.iP.values().iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if (!var1.contains(var4)) {
            var3.remove();
            var2 = true;
         }
      }

      return var2;
   }

   public void clear() {
      this.iP.clear();
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof List)) {
         return false;
      } else {
         List var2 = (List)var1;
         if (this.size() != var2.size()) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.size(); ++var3) {
               if (!this.get(var3).equals(var2.get(var3))) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public int hashCode() {
      return this.iP.hashCode();
   }

   public E get(int var1) {
      return this.iP.get(var1);
   }

   public E set(int var1, E var2) {
      return this.iP.put(var1, var2);
   }

   public void add(int var1, E var2) {
      for(int var3 = this.iP.size(); var3 > var1; --var3) {
         this.iP.put(var3, this.iP.get(var3 - 1));
      }

      this.iP.put(var1, var2);
   }

   public E remove(int var1) {
      return this.iP.remove(var1);
   }

   public int indexOf(Object var1) {
      Iterator var2 = this.iP.entrySet().iterator();

      Entry var3;
      do {
         if (!var2.hasNext()) {
            return -1;
         }

         var3 = (Entry)var2.next();
      } while(!var3.getValue().equals(var1));

      return (Integer)var3.getKey();
   }

   public int lastIndexOf(Object var1) {
      int var2 = -1;
      Iterator var3 = this.iP.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if (var4.getValue().equals(var1)) {
            var2 = (Integer)var4.getKey();
         }
      }

      return var2;
   }

   @NotNull
   public ListIterator<E> listIterator() {
      ListIterator var10000 = (new ArrayList(this.iP.values())).listIterator();
      if (var10000 == null) {
         d(9);
      }

      return var10000;
   }

   @NotNull
   public ListIterator<E> listIterator(int var1) {
      ListIterator var10000 = (new ArrayList(this.iP.values())).listIterator(var1);
      if (var10000 == null) {
         d(10);
      }

      return var10000;
   }

   @NotNull
   public List<E> subList(int var1, int var2) {
      List var10000 = (new ArrayList(this.iP.values())).subList(var1, var2);
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
         var2[0] = "ai/idealistic/vacan/utils/java/ConcurrentList";
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
         var2[1] = "ai/idealistic/vacan/utils/java/ConcurrentList";
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
